package com.wint.service;

import com.wint.models.Comment;

public interface CommentService {
	
	public Comment createComment(Comment comment, Integer postId ,Integer userId) throws Exception;
	
	public Comment findCommentByID(Integer commentId) throws Exception;
	
	public Comment likeComment(Integer CommentId ,Integer userId) throws Exception;
	
	
	

}
