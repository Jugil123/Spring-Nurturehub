package com.appdev.techno.ie.nurturehub.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblbooking")
public class BookingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private int bookingId;
	
	private String recipient;
	private String caregiver;
	
	private String start_date;
	private String end_date;
	
	private int isTerminated;

	public BookingEntity() {
		super();
	}

	public BookingEntity(int bookingId, String recipient, String caregiver, String start_date, String end_date) {
		super();
		this.bookingId = bookingId;
		this.recipient = recipient;
		this.caregiver = caregiver;
		this.start_date = start_date;
		this.end_date = end_date;
		this.isTerminated = 0;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getCaregiver() {
		return caregiver;
	}

	public void setCaregiver(String caregiver) {
		this.caregiver = caregiver;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getIsTerminated() {
		return isTerminated;
	}

	public void setIsTerminated(int isTerminated) {
		this.isTerminated = isTerminated;
	}
	
	
}
