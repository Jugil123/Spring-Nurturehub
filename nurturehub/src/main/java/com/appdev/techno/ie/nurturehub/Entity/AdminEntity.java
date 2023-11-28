package com.appdev.techno.ie.nurturehub.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbladmin")
public class AdminEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	int adminId;
	
	String firstname;
	String lastname;	
	String username;
	String password;
	String contact_information;
	
	private int isDeleted;
	
	public AdminEntity() {
		super();
	}
	
	public AdminEntity(int adminId, String firstname, String lastname, String username, String password,
			String contact_information, int isDeleted) {
		super();
		this.adminId = adminId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.contact_information = contact_information;
		this.isDeleted = isDeleted;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public String getContact_information() {
		return contact_information;
	}

	public void setContact_information(String contact_information) {
		this.contact_information = contact_information;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	
	
}
