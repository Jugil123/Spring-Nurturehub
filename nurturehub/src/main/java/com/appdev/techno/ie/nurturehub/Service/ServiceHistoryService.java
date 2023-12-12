package com.appdev.techno.ie.nurturehub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;
import com.appdev.techno.ie.nurturehub.Entity.ServiceHistoryEntity;
import com.appdev.techno.ie.nurturehub.Repository.CaregiverRepository;
import com.appdev.techno.ie.nurturehub.Repository.ServiceHistoryRepository;

@Service
public class ServiceHistoryService {
	
	@Autowired
    ServiceHistoryRepository shrepo;
	
	@Autowired
	CaregiverRepository crepo;
	
	public ServiceHistoryEntity insertServiceHistory(ServiceHistoryEntity serviceHistory) {
        return shrepo.save(serviceHistory);
    }

	public List<ServiceHistoryEntity> getAllServiceHistory(String caregiver) {
	    CaregiverEntity caregiver2 = crepo.findByUsernameAndIsDeleted(caregiver, 0);
	    if (caregiver2 != null) {
	        // Update the repository method call to match the correct property name
	        List<ServiceHistoryEntity> history = shrepo.findByCaregiver(caregiver2.getUsername());
	        return history;
	    }
	    return null;
	}

}
