package com.appdev.techno.ie.nurturehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;
import com.appdev.techno.ie.nurturehub.Methods.LoginRequest;
import com.appdev.techno.ie.nurturehub.Service.CaregiverService;
import com.appdev.techno.ie.nurturehub.Service.RecipientService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/caregiver")
public class CaregiverController {

	@Autowired
	CaregiverService cserv;
	
	
	//C - Create a recipient record
	@PostMapping("/insertCaregiver")
	public CaregiverEntity insertCaregiver(@RequestBody CaregiverEntity caregiver) {
		return cserv.insertCaregiver(caregiver);
	}
	
	//R - Read all recipient records in tblrecipient
	@GetMapping("/getAllCaregivers")
	public List<CaregiverEntity>getAllCaregivers(){
		return cserv.getAllCaregivers();
	}
	
	//U - Update a recipient record
	@PutMapping("/updateCaregiver")
	public CaregiverEntity updateCaregiver(@RequestParam int cid,@RequestBody CaregiverEntity newCaregiverDetails){
		return cserv.updateCaregiver(cid, newCaregiverDetails);
	}
	
	//D - Delete a recipient record
	@DeleteMapping("/deleteCaregiver/{cid}")
	public String deleteCaregiver(@PathVariable int cid) {
		return cserv.deleteCaregiver(cid);
	}
	
	@PostMapping("/login")
	 public String login(@RequestBody LoginRequest loginRequest) {
		return cserv.login(loginRequest);
    }
	
	@GetMapping("/getCaregiverById/{cid}")
	 public ResponseEntity<CaregiverEntity> getRecipientById(@PathVariable int cid){
		 return cserv.getCaregiverById(cid);
	 }
	
	@GetMapping("/searchCaregiver")
	public ResponseEntity<List<CaregiverEntity>> searchCaregiver(@RequestParam String searchString) {
		return cserv.searchCaregiver(searchString);
	}
}
