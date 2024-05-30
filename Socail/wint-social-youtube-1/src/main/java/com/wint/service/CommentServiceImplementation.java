package com.wint.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wint.models.Comment;
import com.wint.models.Post;
import com.wint.models.User;
import com.wint.repository.CommentRepository;
import com.wint.repository.PostRepository;

@Service
public class CommentServiceImplementation implements CommentService{
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	

	@Override
	public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception {
	
		User user = userService.findUserByID(userId);
		
		Post post= postService.findPostbyId(postId);
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		Comment savedComment =commentRepository.save(comment);
		post.getComments().add(savedComment);
		postRepository.save(post);		
		return savedComment;
	}
	
	
	

	@Override
	public Comment findCommentByID(Integer commentId) throws Exception {
		Optional <Comment> opt = commentRepository.findById(commentId);
		if(opt.isEmpty())
		{
			throw new Exception("Comment not exist");
		}
		
		return opt.get();
	}
	
	

	@Override
	public Comment likeComment(Integer CommentId, Integer userId)throws Exception {
		Comment comment = findCommentByID(CommentId);
		User user = userService.findUserByID(userId);
		if(!comment.getLiked().contains(user))
		{
			comment.getLiked().add(user);
		}
		else comment.getLiked().remove(user);
		
		return commentRepository.save(comment);
	}
	

}
