package com.appdev.techno.ie.nurturehub.Controller;

import java.util.List;

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

import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecordEntity;
import com.appdev.techno.ie.nurturehub.Service.RecipientService;
import com.appdev.techno.ie.nurturehub.Service.RecordService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/record")
public class RecordController {

	@Autowired
	RecordService rserv;
	
	@PostMapping("/insertRecord")
	public RecordEntity insertRecord(@RequestBody RecordEntity record) {
		return rserv.insertRecord(record);
	}
	 
	//R - Read all recipient records in tblrecipient
	@GetMapping("/getAllRecords")
	public List<RecordEntity>getAllRecords(){
		return rserv.getAllRecords();
	}
	 
	//U - Update a recipient record
	@PutMapping("/updateRecord")
	public RecordEntity updateRecord(@RequestParam int rid,@RequestBody RecordEntity newRecordDetails){
		return rserv.updateRecord(rid, newRecordDetails);
	}
	
	//D - Delete a recipient record
	@DeleteMapping("/deleteRecord/{rid}")
	public String deleteRecord(@PathVariable int rid) {
		return rserv.deleteRecord(rid);
	}
	
	@GetMapping("/getRecordByRecipient/{recipient}")
	public RecordEntity getRecordByRecipient(@PathVariable String recipient){
		return rserv.getRecordByRecipient(recipient);
	}
}
