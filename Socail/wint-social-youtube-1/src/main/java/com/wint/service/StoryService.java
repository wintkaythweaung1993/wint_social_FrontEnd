package com.wint.service;

import java.util.List;

import com.wint.models.Story;
import com.wint.models.User;

public interface StoryService {

	public Story createStory (Story story, User user);
	
	public List<Story> findStoryByUserID(Integer UserID) throws Exception;
	
}
