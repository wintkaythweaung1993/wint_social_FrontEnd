package com.wint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wint.models.Message;
import com.wint.models.User;

@Service
public interface MessageService 
{
	public Message createMessage(User user, Integer chatId, Message req) throws Exception;
	
	public List<Message> findChatsMessages(Integer chatId) throws Exception;

}
