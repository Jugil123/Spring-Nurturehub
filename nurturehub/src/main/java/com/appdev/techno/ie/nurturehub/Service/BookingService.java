package com.appdev.techno.ie.nurturehub.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.techno.ie.nurturehub.Entity.BookingEntity;
import com.appdev.techno.ie.nurturehub.Repository.BookingRepository;


@Service
public class BookingService {

	@Autowired
	BookingRepository repo;
	
	public BookingEntity insertBooking(BookingEntity booking) {
		return repo.save(booking);
	}
	
	
	public List<BookingEntity> getAllBookings(){
		return repo.findAll();
	}
	
	@SuppressWarnings("finally")
	public BookingEntity updateBooking(int bid, BookingEntity newBookingDetails) {
		BookingEntity booking = new BookingEntity();
		try {
			//1.)search the id number of student that will be updated
			booking = repo.findById(bid).get();
			
		    //2.) update the record
			booking.setCaregiver(newBookingDetails.getCaregiver());
			booking.setRecipient(newBookingDetails.getRecipient());
			booking.setStart_date(newBookingDetails.getStart_date());
			booking.setEnd_date(newBookingDetails.getEnd_date());
			booking.setIsTerminated(newBookingDetails.getIsTerminated());
			
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Student "+ bid + " does not exist!");
		}finally {
			return repo.save(booking);
		}
	}
	
	public String deleteBooking(int bid) {
		String msg = "";
		
		if(repo.findById(bid) != null) {
			repo.deleteById(bid);
			msg = "Booking " + bid + " is successfully deleted!";
		}
		else
			msg = "Booking " + bid + " does not exist";
		return msg;
		
	}
	
	
}
