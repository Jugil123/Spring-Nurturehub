package com.appdev.techno.ie.nurturehub.Service;

import com.appdev.techno.ie.nurturehub.Entity.FeedBackEntity;
import com.appdev.techno.ie.nurturehub.Repository.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService {
	

    @Autowired
    FeedBackRepository fbrepo;

    public FeedBackEntity insertFeedback(FeedBackEntity feedback) {
        return fbrepo.save(feedback);
    }

    public List<FeedBackEntity> viewRecipientFeedback(int recipientId) {
        return fbrepo.findByRecipientId(recipientId);
    }
    
    public List<FeedBackEntity> getFeedBackByCaregiver(int caregiverId){
    	List<FeedBackEntity> feedback = fbrepo.findByCaregiverIdAndIsDeleted(caregiverId, 0);
    	if(feedback != null) {
    		return feedback;
    	}
    	return null;
    }
}
