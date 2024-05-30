package com.wint.service;

import java.util.List;

import com.wint.models.Chat;
import com.wint.models.User;

public interface ChatService {

	public Chat createChat(User reqUser,User user2);
	
	
	public Chat findChatByID(Integer chatID) throws Exception;
	
	public List<Chat>findUsersChat(Integer userID);
}
