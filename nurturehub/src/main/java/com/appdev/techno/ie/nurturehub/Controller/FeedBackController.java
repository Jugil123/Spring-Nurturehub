package com.appdev.techno.ie.nurturehub.Controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	FeedBackService fbserv;
	
	@PostMapping("/insertFeedback")
	public FeedBackEntity insertFeedBack(@RequestBody FeedBackEntity feedback) {
		return fbserv.insertFeedback(feedback);
	}
	
	@PostMapping("/SearchFeedback")
	public List<FeedBackEntity> searchRecipientFeedback(@RequestParam int recipientId){
		return fbserv.viewRecipientFeedback(recipientId);
	}
}
