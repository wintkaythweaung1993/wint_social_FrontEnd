package com.wint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wint.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	

}
