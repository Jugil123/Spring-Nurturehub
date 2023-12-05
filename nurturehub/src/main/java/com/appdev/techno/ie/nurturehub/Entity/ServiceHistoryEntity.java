package com.appdev.techno.ie.nurturehub.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblservicehistory")
public class ServiceHistoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serviceHistory_id")
	private int serviceHistoryId;
	
	private String recipient;
	private String caregiver;
	
	private String start_date;
	private String end_date;
	 
	private String start_time;
	private String end_time;
	
	public ServiceHistoryEntity() {
		super();
	}

	public ServiceHistoryEntity(int serviceHistoryId, String recipient, String caregiver, String start_date,
			String end_date, String start_time, String end_time) {
		super();
		this.serviceHistoryId = serviceHistoryId;
		this.recipient = recipient;
		this.caregiver = caregiver;
		this.start_date = start_date;
		this.end_date = end_date;
		this.start_time = start_time;
		this.end_time = end_time;
	}

	public int getServiceHistoryId() {
		return serviceHistoryId;
	}

	public void setServiceHistoryId(int serviceHistoryId) {
		this.serviceHistoryId = serviceHistoryId;
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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	

}
