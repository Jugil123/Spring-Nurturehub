package com.appdev.techno.ie.nurturehub.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.techno.ie.nurturehub.Entity.BookingEntity;
import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;
import com.appdev.techno.ie.nurturehub.Repository.BookingRepository;
import com.appdev.techno.ie.nurturehub.Repository.RecipientRepository;


@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	 @Autowired
	RecipientRepository recipientRepository;
	
	public BookingEntity insertBooking(BookingEntity booking) {
		return bookingRepository.save(booking);
	}
	
	
	public List<BookingEntity> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	public List<BookingEntity> getAllBookingsByUsername(String caregiver, String recipient){
		List<BookingEntity> bookingRecords = bookingRepository.findBookingByCaregiverAndRecipientAndIsTerminated(caregiver, recipient, 0);
		
		if(bookingRecords != null) {
			
			return bookingRecords;
		}
		
		return null;
	}
	
	@SuppressWarnings("finally")
	public BookingEntity updateBooking(int bid, BookingEntity newBookingDetails) {
		BookingEntity booking = new BookingEntity();
		try {
			//1.)search the id number of student that will be updated
			booking = bookingRepository.findById(bid).get();
			
		    //2.) update the record
			booking.setCaregiver(newBookingDetails.getCaregiver());
			booking.setRecipient(newBookingDetails.getRecipient());
			booking.setStart_date(newBookingDetails.getStart_date());
			booking.setEnd_date(newBookingDetails.getEnd_date());
			booking.setIsTerminated(newBookingDetails.getIsTerminated());
			
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Student "+ bid + " does not exist!");
		}finally {
			return bookingRepository.save(booking);
		}
	}
	
	public String terminateBooking(int bid) {
		String msg = "";

	    if (bookingRepository.findById(bid).isPresent()) {
	        // Get caregiver by id
	    	BookingEntity booking = bookingRepository.findById(bid).get();
	        
	     // Check if caregiver is already deleted
	        if (booking.getIsTerminated() == 1) {
	            msg = "Booking " + bid + " is already deleted!";
	        } else {
	            // Set isDeleted to 1 instead of physically deleting
	        	booking.setIsTerminated(1);
	            bookingRepository.save(booking);
	            msg = "Booking " + bid + " is successfully marked as deleted!";
	        }
	    } else {
	        msg = "Booking " + bid + " does not exist";
	    }

	    return msg;
		
	}
	
	public String deleteBooking(int bid) {
		String msg = "";
		
		if(bookingRepository.findById(bid) != null ) {
			bookingRepository.deleteById(bid);
			msg = "Booking " + bid + " is successfuly deleted!";
		}else 
			msg = "Booking "+ bid + "does not exist.";
			
		return msg;
		
	}
	
	public Map<String, Object> getAllBookingRequest(String username) {
	    Map<String, Object> result = new HashMap<>();

	    // Find bookings by caregiver's username and isTerminated == 0
	    List<BookingEntity> bookings = bookingRepository.findByCaregiverAndIsTerminated(username, 0);

	    // Check if there are bookings
	    if (!bookings.isEmpty()) {
	        // Create a list to store transformed bookings
	        List<Map<String, Object>> transformedBookings = new ArrayList<>();

	        // Iterate through each booking
	        for (BookingEntity booking : bookings) {
	            // Retrieve the recipient by username for each booking
	            RecipientEntity recipient = recipientRepository.findByUsernameAndIsDeleted(booking.getRecipient(), 0);

	            // Create a map to store booking details along with recipient
	            Map<String, Object> bookingMap = new HashMap<>();
	            bookingMap.put("booking", booking);
	            bookingMap.put("recipient", recipient);

	            // Add the map to the list
	            transformedBookings.add(bookingMap);
	        }

	        // Add the list of transformed bookings to the result map
	        result.put("bookings", transformedBookings);

	        // Add additional logic if needed...
	    }

	    return result;
	}
	
	
	
	
}
