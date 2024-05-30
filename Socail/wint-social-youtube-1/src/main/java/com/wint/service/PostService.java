package com.wint.service;

import java.util.List;

import com.wint.models.Post;

public interface PostService {

	Post createNewPost(Post post ,Integer userId) throws Exception;
	
	String deletePost(Integer postId, Integer userId) throws Exception;
	
	List<Post> findpostByUserId(Integer userId);
	
	Post findPostbyId(Integer postId) throws Exception;
	
	List <Post> findAllPost();
	
	Post savedPost(Integer postId,Integer userId) throws Exception;
	
	Post LikePost(Integer postId, Integer userId) throws Exception;
	
	
}
