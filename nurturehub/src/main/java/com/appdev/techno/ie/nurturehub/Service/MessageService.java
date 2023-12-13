package com.appdev.techno.ie.nurturehub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.techno.ie.nurturehub.Entity.MessageEntity;
import com.appdev.techno.ie.nurturehub.Repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messagerepo;
	
	public MessageEntity insertMessage(MessageEntity message) {
		return messagerepo.save(message);
	}
}
