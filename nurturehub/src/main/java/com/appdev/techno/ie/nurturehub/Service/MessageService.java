package com.appdev.techno.ie.nurturehub.Service;

import java.util.List;

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
	
	public List<MessageEntity> getMessagesByMessageKey(String messageKey){
		List<MessageEntity> messages = messagerepo.findByMessageKey(messageKey);
		
		if(messages != null) {
			return messages;
		}
		
		return null;
	}
}
