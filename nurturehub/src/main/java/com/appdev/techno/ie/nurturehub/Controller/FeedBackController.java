package com.appdev.techno.ie.nurturehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.techno.ie.nurturehub.Entity.FeedBackEntity;
import com.appdev.techno.ie.nurturehub.Service.FeedBackService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/feedback")
public class FeedBackController {
	
	@Autowired
	FeedBackService fbserv;
	
	@PostMapping("/insertFeedback")
	public FeedBackEntity insertFeedBack(@RequestBody FeedBackEntity feedback) {
		return fbserv.insertFeedback(feedback);
	}
	
	@PostMapping("/SearchFeedback")
	public List<FeedBackEntity> searchRecipientFeedback(@RequestParam int recipientId){
		return fbserv.viewRecipientFeedback(recipientId);
	}
	
	@GetMapping("/getFeedBackByCaregiver")
	public List<FeedBackEntity> getFeedBackByCaregiver(@RequestParam int caregiverId){
		return fbserv.getFeedBackByCaregiver(caregiverId);
	}
}
