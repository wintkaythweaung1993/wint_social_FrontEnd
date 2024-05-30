package com.wint.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wint.models.Chat;
import com.wint.models.User;
import com.wint.repository.ChatRepository;

@Service
public class ChatServiceImplementation implements ChatService{
	@Autowired
	private ChatRepository chatRepository;
	
	
	@Override
	public Chat createChat(User reqUser, User user2) {
		
		Chat IsExist = chatRepository.findChatByUserID(user2, reqUser);
		if(IsExist != null)
		{
			return IsExist;
		}
		
		Chat chat = new Chat();
		chat.getUser().add(user2);
		chat.getUser().add(reqUser);
		chat.setTimestamp(LocalDateTime.now());
		return chatRepository.save(chat);
	}

	@Override
	public Chat findChatByID(Integer chatID) throws Exception {
		Optional<Chat> opt = chatRepository.findById(chatID);
		if(opt.isEmpty())
		{
			throw new Exception ("Chat not found with given id -->"+ chatID);
		}
		return opt.get();
	}

	@Override
	public List<Chat> findUsersChat(Integer userID) {
		// TODO Auto-generated method stub
	//	return null;
		return chatRepository.findByUserId(userID);
	}

}
