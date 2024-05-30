package com.wint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wint.models.Reel;
import com.wint.models.User;
import com.wint.repository.ReelRepository;

@Service
public class ReelServiceImplementation implements ReelService{

	@Autowired
	private ReelRepository reelRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Reel createReel(Reel reel, User user) {
	
	Reel createReel = new Reel();
	
	createReel.setTitle(reel.getTitle());
	createReel.setUser(user);
	createReel.setVideo(reel.getVideo());
	
		
		return reelRepository.save(createReel);
	}

	@Override
	public List<Reel> FindAllReels() {
		// TODO Auto-generated method stub
		return reelRepository.findAll();
	}

	@Override
	public List<Reel> findUserReel(Integer userId) throws Exception{
		userService.findUserByID(userId);
		return reelRepository.findRByuserId(userId);
		
		
	
	}

}
