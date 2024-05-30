package com.wint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wint.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

	
	 List<Message> findByChatId(Integer ChatId);
	
}
