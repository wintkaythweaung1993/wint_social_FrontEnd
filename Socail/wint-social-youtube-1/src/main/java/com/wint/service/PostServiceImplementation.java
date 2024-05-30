package com.wint.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wint.models.Post;
import com.wint.models.User;
import com.wint.repository.PostRepository;
import com.wint.repository.UserRepository;

@Service
public class PostServiceImplementation implements PostService{
	
	@Autowired
	PostRepository postRepository;
	

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository ;

	@Override
	public Post createNewPost(Post post, Integer UserID) throws Exception {
		// TODO Auto-generated method stub
		User user1 = userService.findUserByID(UserID);
		Post newPost= new Post();
		newPost.setCaption(post.getCaption());
		newPost.setImage(post.getImage());
		newPost.setVideo(post.getVideo());
		newPost.setCreatedAt(LocalDateTime.now());
		
	
		newPost.setUser(user1);
		return postRepository.save(newPost);
		
		
	}


	@Override
	public String deletePost(Integer postId, Integer UserID) throws Exception {
		Post post = findPostbyId(postId);
		User user = userService.findUserByID(UserID);
		if(post.getUser().getId()!= user.getId())
		{
			throw new Exception ("You can't delete anther user's post");
		}
		postRepository.delete(post);
		return "Post deleted successfully";
	}

	@Override
	public List<Post> findpostByUserId(Integer UserID) {
		
		
		
		return postRepository.findPostByuserId(UserID);
	}
	


	@Override
	public Post findPostbyId(Integer postId) throws Exception {
		
		Optional<Post> opt = postRepository.findById(postId);
		if(opt.isEmpty())
		{
			throw new Exception ("Post not found " +postId );
		}
		return opt.get();
	}


	@Override
	public List<Post> findAllPost() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}


	@Override
	public Post savedPost(Integer postId, Integer UserID) throws Exception {

		Post post = findPostbyId(postId);
		User user =userService.findUserByID(UserID);
		if(user.getSavedPost().contains(post))
		{
			user.getSavedPost().remove(post);
		}
		else 
		
			user.getSavedPost().add(post);
		
		
		 userRepository.save(user);
		 return post;
	}


	@Override
	public Post LikePost(Integer postId, Integer userId) throws Exception {
		Post post = findPostbyId(postId);
		User user =userService.findUserByID(userId);
		if (post.getLiked().contains(user))
		{
			post.getLiked().remove(user);
		}
		else 
		{
			post.getLiked().add(user);
		}
	
		return postRepository.save(post);
	}

}
	