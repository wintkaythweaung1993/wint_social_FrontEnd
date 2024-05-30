package com.wint.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wint.models.Chat;
import com.wint.models.Message;
import com.wint.models.User;
import com.wint.repository.ChatRepository;
import com.wint.repository.MessageRepository;

@Service
public class MessageServiceImplementation implements MessageService{

	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ChatRepository chatRepository;
	

	@Override
	public Message createMessage(User user, Integer id, Message req) throws Exception {
		Message message = new Message();
		Chat chat = chatService.findChatByID(id); 
		message.setChat(chat);
		message.setContent(req.getContent());
		message.setImage(req.getImage());
		message.setUser(user);
		message.setTimeStamp(LocalDateTime.now());
		Message savedMessage =messageRepository.save(message);
		chat.getMessage().add(savedMessage);
		chatRepository.save(chat);
		return savedMessage;
	}
	
	

	@Override
	public List<Message> findChatsMessages(Integer id) throws Exception {
		
		Chat chat = chatService.findChatByID( id);
		
		return messageRepository.findByChatId(id);
	}


}
