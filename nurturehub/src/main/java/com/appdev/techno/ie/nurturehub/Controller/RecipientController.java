package com.appdev.techno.ie.nurturehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.multipart.MultipartFile;

import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;
import com.appdev.techno.ie.nurturehub.Methods.LoginRequest;
import com.appdev.techno.ie.nurturehub.Service.RecipientService;




@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/recipient")
public class RecipientController {
	
	@Autowired
	RecipientService rserv;

	
	//C - Create a recipient record
	@PostMapping("/insertRecipient")
	public RecipientEntity insertRecipient(@RequestBody RecipientEntity recipient) {
		return rserv.insertRecipient(recipient);
	}
	
	//R - Read all recipient records in tblrecipient
	@GetMapping("/getAllRecipients")
	public List<RecipientEntity>getAllRecipients(){
		return rserv.getAllRecipients();
	}
	
	//U - Update a recipient record
	@PutMapping("/updateRecipient")
	public RecipientEntity updateRecipient(@RequestParam int rid,@RequestBody RecipientEntity newRecipientDetails){
		return rserv.updateRecipient(rid, newRecipientDetails);
	}
	
	//D - Delete a recipient record
	@DeleteMapping("/deleteRecipient/{rid}")
	public String deleteRecipient(@PathVariable int rid) {
		return rserv.deleteRecipient(rid);
	}
	
	@PostMapping("/login")
	 public String login(@RequestBody LoginRequest loginRequest) {
		return rserv.login(loginRequest);
    }
	 
	 @GetMapping("/getRecipientById/{rid}")
	 public ResponseEntity<RecipientEntity> getRecipientById(@PathVariable int rid){
		 return rserv.getRecipientById(rid);
	 }
	 
	 @PutMapping("/updateRecipientBooked")
		public RecipientEntity updateRecipientBooked(@RequestParam int rid,@RequestBody RecipientEntity newRecipientDetails){
			return rserv.updateRecipientBooked(rid, newRecipientDetails);
		}
	 
	 @PostMapping("/recipients/{recipientId}/profile-picture")
	    public ResponseEntity<String> updateProfilePicture(
	            @RequestParam("file") MultipartFile file,
	            @PathVariable int recipientId) {
	        
	        // Implement the logic to save/update the profile picture in the recipient service
		 rserv.updateProfilePicture(recipientId, file);

	        return ResponseEntity.ok("Profile picture updated successfully");
	    }
}
