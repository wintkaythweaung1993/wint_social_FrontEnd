package com.wint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.wint.models.Story;
import com.wint.models.User;
import com.wint.service.StoryService;
import com.wint.service.UserService;

@RestController
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/story")
	private Story createStory(@RequestBody Story story, @RequestHeader("Authorization")String jwt)
	{
		User reqUser = userService.FindUserByJwt(jwt);
		Story createdStory = storyService.createStory(story, reqUser);
		return createdStory;
	}
	
	@GetMapping("/api/story/user/{userId}")
	private List<Story> findUserStory(@PathVariable Integer userId, @RequestHeader("Authorization")String jwt) throws Exception
	{
		User reqUser = userService.FindUserByJwt(jwt);
		List<Story> stories = storyService.findStoryByUserID( userId);
		return stories;
	}
	
	
	


}
