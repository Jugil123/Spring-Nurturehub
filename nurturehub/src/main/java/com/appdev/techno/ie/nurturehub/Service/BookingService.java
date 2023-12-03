package com.appdev.techno.ie.nurturehub.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.techno.ie.nurturehub.Entity.BookingEntity;
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
	
	public String deleteBooking(int bid) {
		String msg = "";
		
		if(bookingRepository.findById(bid) != null) {
			bookingRepository.deleteById(bid);
			msg = "Booking " + bid + " is successfully deleted!";
		}
		else
			msg = "Booking " + bid + " does not exist";
		return msg;
		
	}
	
	public Map<String, Object> getAllBookingRequest(String username) {
	    Map<String, Object> result = new HashMap<>();

	    // Find bookings by caregiver's username
	    List<BookingEntity> bookings = bookingRepository.findByCaregiver(username);

	    // Check if there are bookings
	    if (!bookings.isEmpty()) {
	        // Create a list to store transformed bookings
	        List<Map<String, Object>> transformedBookings = new ArrayList<>();

	        // Iterate through each booking
	        for (BookingEntity booking : bookings) {
	            // Retrieve the recipient by username for each booking
	            RecipientEntity recipient = recipientRepository.findByUsername(booking.getRecipient());

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
