package com.appdev.techno.ie.nurturehub.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblrecord")
public class RecordEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "record_id")
	private int recordId;
	
	private String recipient;
	private String allergies;
	private String medical_conditions;
	private String medications;
	private String past_surgeries;
	private String family_history;
	
	public RecordEntity() {
		super();
	}

	public RecordEntity(int recordId, String recipient, String allergies, String medical_conditions, String medications,
			String past_surgeries, String family_history) {
		super();
		this.recordId = recordId;
		this.recipient = recipient;
		this.allergies = allergies;
		this.medical_conditions = medical_conditions;
		this.medications = medications;
		this.past_surgeries = past_surgeries;
		this.family_history = family_history;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getMedical_conditions() {
		return medical_conditions;
	}

	public void setMedical_conditions(String medical_conditions) {
		this.medical_conditions = medical_conditions;
	}

	public String getMedications() {
		return medications;
	}

	public void setMedications(String medications) {
		this.medications = medications;
	}

	public String getPast_surgeries() {
		return past_surgeries;
	}

	public void setPast_surgeries(String past_surgeries) {
		this.past_surgeries = past_surgeries;
	}

	public String getFamily_history() {
		return family_history;
	}

	public void setFamily_history(String family_history) {
		this.family_history = family_history;
	}
	
	
	
	

}
