package com.wint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wint.models.Chat;
import com.wint.models.User;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
	
	//@Query("SELECT c FROM Chat c WHERE c.user.UserID = :UserID")
	// @Query("SELECT c FROM Chat c JOIN c.user u WHERE u.id= :id")
	 List<Chat> findByUserId(Integer id);
	
	@Query ("Select c from Chat c where :user Member of c.user And :reqUser Member of c.user")
	//  @Query("SELECT c FROM Chat c JOIN c.user u WHERE u = :user AND :reqUser MEMBER OF c.user")
	    
	 public Chat findChatByUserID(@Param ("user")User user, @Param("reqUser")User reqUser);
	

}
