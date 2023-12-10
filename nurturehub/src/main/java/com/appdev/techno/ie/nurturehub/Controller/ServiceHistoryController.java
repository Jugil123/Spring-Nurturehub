package com.appdev.techno.ie.nurturehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.techno.ie.nurturehub.Entity.ServiceHistoryEntity;
import com.appdev.techno.ie.nurturehub.Service.ServiceHistoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/serviceHistory")
public class ServiceHistoryController {
	
	 @Autowired
	    ServiceHistoryService shserv;

	 	@PostMapping("/insertServiceHistory")
	 	public ServiceHistoryEntity insertServiceHistory(@RequestBody ServiceHistoryEntity serviceHistory) {
	        return shserv.insertServiceHistory(serviceHistory);
	    }
	 
	    @GetMapping("/getAllServiceHistory")
	    public List<ServiceHistoryEntity> getAllServiceHistory(@PathVariable String recipient) {
	        return shserv.viewServiceHistory(recipient);
	    }
	}
