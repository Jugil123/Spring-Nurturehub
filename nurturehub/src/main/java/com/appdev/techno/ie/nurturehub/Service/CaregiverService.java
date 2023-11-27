package com.appdev.techno.ie.nurturehub.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appdev.techno.ie.nurturehub.Entity.AccountEntity;
import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;
import com.appdev.techno.ie.nurturehub.Methods.LoginRequest;
import com.appdev.techno.ie.nurturehub.Methods.MyCustomException;
import com.appdev.techno.ie.nurturehub.Repository.AccountRepository;
import com.appdev.techno.ie.nurturehub.Repository.CaregiverRepository;
import com.appdev.techno.ie.nurturehub.Repository.RecipientRepository;

@Service
public class CaregiverService {
 
	@Autowired
	CaregiverRepository crepo;
	
	@Autowired
	AccountRepository arepo;
	
	@Autowired
	AccountService aserv;
	
	
	//C - Create or insert caregiver record in tblcaregiver
	public CaregiverEntity insertCaregiver(CaregiverEntity caregiver) {
	    // Check if the username already exists in the AccountEntity
	    AccountEntity existingAccount = arepo.findByUsername(caregiver.getUsername());
	    if (existingAccount != null) {
	        // Handle the case where the username already exists
	        // For example, you might throw an exception or return null
	        // depending on how you want to handle this situation.
	        throw new MyCustomException("Username already exists");
	    }

	    // If the username is not found, save the caregiver
	    return crepo.save(caregiver);
	}

	
	//R - read all records in tblcaregiver
	public List<CaregiverEntity> getAllCaregivers(){
		return crepo.findAll();
	}
	
	//U - update a caregiver
	@SuppressWarnings("finally")
	public CaregiverEntity updateCaregiver(int cid, CaregiverEntity newCaregiverDetails) {
		CaregiverEntity caregiver = new CaregiverEntity();
		try {
			//1.)search the id number of caregiver that will be updated
			caregiver = crepo.findById(cid).get();
			
		    //2.) update the record
			caregiver.setFirstname(newCaregiverDetails.getFirstname());
			caregiver.setLastname(newCaregiverDetails.getLastname());
			caregiver.setPassword(newCaregiverDetails.getPassword());
			caregiver.setBirth_date(newCaregiverDetails.getBirth_date());
			caregiver.setGender(newCaregiverDetails.getGender());
			caregiver.setContact_information(newCaregiverDetails.getContact_information());
			caregiver.setAddress(newCaregiverDetails.getAddress());
			caregiver.setSpecializations(newCaregiverDetails.getSpecializations());
			caregiver.setAvailability(newCaregiverDetails.getAvailability());
			caregiver.setHourlyRate(newCaregiverDetails.getHourlyRate());
			
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Caregiver "+ cid + " does not exist!");
		}finally {
			return crepo.save(caregiver);
		}
	} 
	
	//D - delete a caregiver
	public String deleteCaregiver(int cid) {
	    String msg = "";

	    if (crepo.findById(cid).isPresent()) {
	        // Get caregiver by id
	        CaregiverEntity caregiver = crepo.findById(cid).get();
	        
	     // Check if caregiver is already deleted
	        if (caregiver.getIsDeleted() == 1) {
	            msg = "Caregiver " + cid + " is already deleted!";
	        } else {
	            // Set isDeleted to 1 instead of physically deleting
	            caregiver.setIsDeleted(1);
	            crepo.save(caregiver);
	            msg = "Caregiver " + cid + " is successfully marked as deleted!";
	        }
	    } else {
	        msg = "Caregiver " + cid + " does not exist";
	    }

	    return msg;

	}

	 public String login(LoginRequest loginRequest) {
		 String username = loginRequest.getUsername();
	        String password = loginRequest.getPassword();

	        // Implement your custom logic to authenticate the user
	        CaregiverEntity user = crepo.findByUsername(username);

	        if (user != null && user.getPassword().equals(password)) {
	            return "Login Successful";
	        } else {
	            return "Login Failed";
	        }
	 }
	 
	 public ResponseEntity<CaregiverEntity> getCaregiverById(int caregiverId) {
		 CaregiverEntity caregiver = crepo.findById(caregiverId).orElse(null);
	        if (caregiver != null) {
	            return ResponseEntity.ok(caregiver);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 public ResponseEntity<List<CaregiverEntity>> searchCaregiver(String searchString) {
		    List<CaregiverEntity> caregivers = crepo.findByCombinedName(searchString);

		    if (!caregivers.isEmpty()) {
		        return ResponseEntity.ok(caregivers);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	 }
}
