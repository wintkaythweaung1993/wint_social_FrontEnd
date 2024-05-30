package com.wint.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wint.models.Story;
import com.wint.models.User;
import com.wint.repository.StoryRepository;

@Service
public class StoryServiceImplementation implements StoryService{

	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	private UserService userService;

	@Override
	public Story createStory(Story story, User user) {
		// TODO Auto-generated method stub
		
		
		Story createdStory = new Story();
		createdStory.setCaption(story.getCaption());
		createdStory.setImage(story.getImage());;
		createdStory.setUser(user);
		createdStory.setTimeStamp(LocalDateTime.now());
		return storyRepository.save(createdStory);
		
	}

	@Override
	public List<Story> findStoryByUserID(Integer userId) throws Exception {
		User user= userService.findUserByID(userId);
		return storyRepository.findByUserID(userId);
	
	}
	
	
}
