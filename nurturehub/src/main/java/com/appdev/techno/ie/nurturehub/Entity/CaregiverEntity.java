package com.appdev.techno.ie.nurturehub.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="tblcaregiver")
public class CaregiverEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "caregiver_id")
	private int caregiverId;
	
	private String firstname;
	private String lastname;
	
	private String username;
	
	private String password;
	private String birth_date;
	private String gender;
	private String contact_information;
	private String address;
	private String specializations;
	private double hourlyRate;
	private int isDeleted;
	private int isBooked;
	
	
	@Lob
    @Column(name = "profile_picture")
    private byte[] profilePicture;

	
	public CaregiverEntity() {
		super();
	}
     
	public CaregiverEntity(int caregiverId, String firstname, String lastname, String username, String password,
			String birth_date, String gender, String contact_information, String address, String specializations,
			double hourlyRate, byte[] profilePicture) {
		super();
		this.caregiverId = caregiverId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.birth_date = birth_date;
		this.gender = gender;
		this.contact_information = contact_information;
		this.address = address;
		this.specializations = specializations;
		this.hourlyRate = hourlyRate;
		this.isDeleted = 0;
		this.isBooked = 0;
		this.profilePicture = profilePicture;
	}

	public int getCaregiverId() {
		return caregiverId;
	}

	public void setCaregiverId(int caregiverId) {
		this.caregiverId = caregiverId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact_information() {
		return contact_information;
	}

	public void setContact_information(String contact_information) {
		this.contact_information = contact_information;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpecializations() {
		return specializations;
	}

	public void setSpecializations(String specializations) {
		this.specializations = specializations;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(int isBooked) {
		this.isBooked = isBooked;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	
	
}
