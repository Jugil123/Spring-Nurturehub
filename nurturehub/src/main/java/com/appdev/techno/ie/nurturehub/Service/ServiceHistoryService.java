package com.appdev.techno.ie.nurturehub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.techno.ie.nurturehub.Entity.ServiceHistoryEntity;
import com.appdev.techno.ie.nurturehub.Repository.ServiceHistoryRepository;

@Service
public class ServiceHistoryService {
	
	@Autowired
    ServiceHistoryRepository shrepo;

    public List<ServiceHistoryEntity> viewServiceHistory(String recipient) {
        return shrepo.findByRecipient(recipient);
    }

}
