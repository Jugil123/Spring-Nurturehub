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
		List<MessageEntity> messages = messagerepo.findByMessageKeyAndIsDeleted(messageKey,0);
		
		if(messages != null) {
			return messages;
		}
		
		return null;
	}
	
	public List<MessageEntity> getMessageByPartialMessageKey(String messageKey){
		List<MessageEntity> messages = messagerepo.findByPartialMessageKeyAndIsDeleted(messageKey, 0);
		
		if(messages != null) {
			return messages;
		}
		
		return null;
	}
	
	public void deleteMessages(String messageKey) {
		List<MessageEntity> messages = messagerepo.findByPartialMessageKeyAndIsDeleted(messageKey, 0);
		
		if(messages!=null) {
			for(MessageEntity message: messages) {
				message.setIsDeleted(1);
				
				messagerepo.save(message);
			}
		}
		
	}
}
