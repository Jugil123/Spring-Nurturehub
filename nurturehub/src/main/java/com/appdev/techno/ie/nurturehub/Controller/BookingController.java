package com.appdev.techno.ie.nurturehub.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.techno.ie.nurturehub.Entity.BookingEntity;
import com.appdev.techno.ie.nurturehub.Service.BookingService;




@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService bserv;
	
	@PostMapping("/insertBooking")
	public BookingEntity insertBooking(@RequestBody BookingEntity booking) {
		return bserv.insertBooking(booking);
	}
	
	@GetMapping("/getAllBookings")
	public List<BookingEntity>getAllBookings(){
		return bserv.getAllBookings();
	}
	
	@GetMapping("/getAllBookingsByUsername")
	List<BookingEntity> getAllBookingsByUsername(@RequestParam String caregiver, @RequestParam String recipient){
		return bserv.getAllBookingsByUsername(caregiver, recipient);
	}
	
	@PutMapping("/updateBooking")
	public BookingEntity updateBooking(@RequestParam int bid,@RequestBody BookingEntity newBookingDetails){
		return bserv.updateBooking(bid, newBookingDetails);
	}
	
	@DeleteMapping("/terminateBooking/{bid}")
	public String terminateBooking(@PathVariable int bid) {
		return bserv.terminateBooking(bid);
	}
	
	@DeleteMapping("/deleteBooking/{bid}")
	public String deleteBooking(@PathVariable int bid) {
		return bserv.deleteBooking(bid);
	}
	
	@GetMapping("/getAllBookingRequest/{username}")
	public Map<String, Object> getAllBookingRequest(@PathVariable String username) {
		return bserv.getAllBookingRequest(username);
	}
	
	
}
