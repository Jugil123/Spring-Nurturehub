package com.appdev.techno.ie.nurturehub.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.techno.ie.nurturehub.Entity.RecordEntity;
import com.appdev.techno.ie.nurturehub.Repository.RecipientRepository;
import com.appdev.techno.ie.nurturehub.Repository.RecordRepository;



@Service
public class RecordService {
	
	@Autowired
	RecordRepository rrepo;
	
	public RecordEntity insertRecord(RecordEntity record) {
		return rrepo.save(record);
	}
	
	public List<RecordEntity> getAllRecords(){
		return rrepo.findAll();
	}
	
	@SuppressWarnings("finally")
	public RecordEntity updateRecord(int rid, RecordEntity newRecordDetails) {
		RecordEntity record = new RecordEntity();
		try {
			//1.)search the id number of student that will be updated
			record = rrepo.findById(rid).get();
			
		    //2.) update the record
			record.setAllergies(newRecordDetails.getAllergies());
			record.setMedical_conditions(newRecordDetails.getMedical_conditions());
			record.setMedications(newRecordDetails.getMedications());
			record.setPast_surgeries(newRecordDetails.getPast_surgeries());
			record.setFamily_history(newRecordDetails.getFamily_history());
			
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Record "+ rid + " does not exist!");
		}finally {
			return rrepo.save(record);
		}
	}
	
	public String deleteRecord(int rid) {
		String msg = "";
		
		if(rrepo.findById(rid) != null) {
			rrepo.deleteById(rid);
			msg = "Record " + rid + " is successfully deleted!";
		}
		else
			msg = "Record " + rid + " does not exist";
		return msg;
		
	}
	
	public RecordEntity getRecordByRecipient(String recipient) {
        return rrepo.findByRecipient(recipient);
    }

}
