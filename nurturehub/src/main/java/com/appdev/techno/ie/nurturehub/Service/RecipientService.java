package com.appdev.techno.ie.nurturehub.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.appdev.techno.ie.nurturehub.Entity.AccountEntity;
import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;
import com.appdev.techno.ie.nurturehub.Methods.LoginRequest;
import com.appdev.techno.ie.nurturehub.Methods.MyCustomException;
import com.appdev.techno.ie.nurturehub.Repository.AccountRepository;
import com.appdev.techno.ie.nurturehub.Repository.RecipientRepository;

 

@Service
public class RecipientService {

	@Autowired
	RecipientRepository rrepo;
	
	@Autowired
	AccountRepository arepo;
	
	@Autowired
	AccountService aserv;
	
	//C - Create or insert recipient record in tblrecipient
	public RecipientEntity insertRecipient(RecipientEntity recipient) {
	    // Check if the username already exists in the AccountEntity
	    AccountEntity existingAccount = arepo.findByUsernameAndIsDeleted(recipient.getUsername(), 0);
	    if (existingAccount != null) {

	        throw new MyCustomException("Username already exists");
	    }

	    // If the username is not found, save the caregiver 
	    return rrepo.save(recipient);
	}
	
	//R - read all records in tblrecipient
	public List<RecipientEntity> getAllRecipients(){
		return rrepo.findByIsDeleted(0);
	}
	
	//U - update a recipient
	@SuppressWarnings("finally")
	public RecipientEntity updateRecipient(int rid, RecipientEntity newRecipientDetails) {
		RecipientEntity recipient = new RecipientEntity();
		try {
			//1.)search the id number of recipient that will be updated
			recipient = rrepo.findById(rid).get();
			  
		    //2.) update the record
			recipient.setFirstname(newRecipientDetails.getFirstname());
			recipient.setLastname(newRecipientDetails.getLastname());
			recipient.setPassword(newRecipientDetails.getPassword());
			recipient.setBirth_date(newRecipientDetails.getBirth_date());
			recipient.setGender(newRecipientDetails.getGender());
			recipient.setContact_info(newRecipientDetails.getContact_info());
			recipient.setAddress(newRecipientDetails.getAddress());
			recipient.setAge(newRecipientDetails.getAge());
			   
			
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Recipient "+ rid + " does not exist!");
		}finally {
			return rrepo.save(recipient);
		}
	}
	
	//D - delete a recipient
	public String deleteRecipient(int rid) {
	    String msg = "";

	    if (rrepo.findById(rid).isPresent()) {
	        // Get recipient by id
	        RecipientEntity recipient = rrepo.findById(rid).get();
	        	        
		     // Check if caregiver is already deleted
		        if (recipient.getIsDeleted() == 1) {
		            msg = "Recipient " + rid + " is already deleted!";
		        } else {
		            // Set isDeleted to 1 instead of physically deleting
		            recipient.setIsDeleted(1);
		            rrepo.save(recipient);
		            msg = "Recipient " + rid + " is successfully marked as deleted!";
		        }
		    } else {
		        msg = "Recipient " + rid + " does not exist";
		    }

		    return msg;
	}

	
	 public String login(LoginRequest loginRequest) {
		 String username = loginRequest.getUsername();
	        String password = loginRequest.getPassword();

	        // Implement your custom logic to authenticate the user
	        RecipientEntity user = rrepo.findByUsername(username);

	        if (user != null && user.getPassword().equals(password)) {
	            return "Login Successful";
	        } else {
	            return "Login Failed";
	        }
	 }
	 
	 
	 public ResponseEntity<RecipientEntity> getRecipientById(int recipientId) {
	        RecipientEntity recipient = rrepo.findById(recipientId).orElse(null);
	        if (recipient != null) {
	            return ResponseEntity.ok(recipient);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 
	 @SuppressWarnings("finally")
	public RecipientEntity updateRecipientBooked(int rid, RecipientEntity newRecipientBooked) {
			RecipientEntity recipient = new RecipientEntity();
			try {
				//1.)search the id number of recipient that will be updated
				recipient = rrepo.findById(rid).get();
				  
			    //2.) update the record
				recipient.setIsBooked(newRecipientBooked.getIsBooked());
				   
				
			}catch(NoSuchElementException ex) {
				throw new NoSuchElementException("Recipient "+ rid + " does not exist!");
			}finally {
				return rrepo.save(recipient);
			}
		}
}
