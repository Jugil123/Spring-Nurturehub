package com.appdev.techno.ie.nurturehub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.techno.ie.nurturehub.Entity.MessageEntity;
import com.appdev.techno.ie.nurturehub.Service.MessageService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@PostMapping("/insertMessage")
	public MessageEntity insertMessage(@RequestBody MessageEntity message) {
		return messageService.insertMessage(message);
	}
	
	@GetMapping("/getMessage")
	public List<MessageEntity> getMessagesByMessageKey(@RequestParam String messageKey){
		return messageService.getMessagesByMessageKey(messageKey);
	}
	
	@GetMapping("/getMessagebyPartialKey")
	public List<MessageEntity> getMessageByPartialMessageKey(@RequestParam String messageKey){
		return messageService.getMessageByPartialMessageKey(messageKey);
	}
	
	@DeleteMapping("/deleteMessagebyPartialKey")
	public void deleteMessage(@RequestParam String messageKey){
		messageService.deleteMessages(messageKey);
	}
	
	@PutMapping("/updateSenderOrReceiver")
	public void updateSenderOrReceiver(@RequestParam String name, @RequestParam String oldname, @RequestParam String messageKey) {
		messageService.updateSenderOrReceiver(name, oldname, messageKey);
	}
}
