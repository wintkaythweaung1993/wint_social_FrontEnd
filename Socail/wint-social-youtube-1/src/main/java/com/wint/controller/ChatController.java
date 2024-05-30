package com.wint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.wint.config.jwtProvider;
import com.wint.models.Chat;
import com.wint.models.Post;
import com.wint.models.Reel;
import com.wint.models.User;
import com.wint.request.CreateChatRequest;
import com.wint.service.ChatService;
import com.wint.service.UserService;

@RestController
public class ChatController {

	@Autowired
	private ChatService chatService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/chats")
	private Chat createChat(@RequestHeader("Authorization")String jwt,@RequestBody CreateChatRequest req) throws Exception {
		User reqUser = userService.FindUserByJwt(jwt);
		User user2 = userService.findUserByID(req.getUserId());
		
		Chat chat = chatService.createChat(reqUser ,user2);
		return chat;
	}
	
	@GetMapping("/api/chats")
	private List<Chat> findUsersChat(@RequestHeader("Authorization")String jwt
		) {
		User user = userService.FindUserByJwt(jwt);
		List<Chat> chat = chatService.findUsersChat(user.getId());
		
		return chat;
	}
}
