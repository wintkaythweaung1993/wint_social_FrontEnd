package com.wint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.wint.models.Chat;
import com.wint.models.Message;
import com.wint.models.User;
import com.wint.service.MessageService;
import com.wint.service.UserService;

@RestController
public class CreateMessage {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/messages/chat/{chatId}")
	public Message createmessage(@RequestBody Message req,
			@PathVariable Integer chatId,@RequestHeader("Authorization")String jwt) throws Exception
	{
		User user= userService.FindUserByJwt(jwt);
		Message message =messageService.createMessage(user, chatId, req);
		return message;
	}
	

	@GetMapping("/api/messages/chat/{id}")
	public List<Message> findChatMessage(@PathVariable Integer chatId,
			@RequestHeader("Authorization")String jwt) throws Exception
	{
		User user= userService.FindUserByJwt(jwt);
		
		List<Message>message =messageService.findChatsMessages(chatId);
		return message;
	}
	
}
