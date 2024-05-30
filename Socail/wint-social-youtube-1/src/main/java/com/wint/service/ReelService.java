package com.wint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wint.models.Reel;
import com.wint.models.User;

@Service
public interface ReelService {
	
	public Reel createReel(Reel reel, User user);
	
	public List<Reel> FindAllReels();
	
	public List <Reel> findUserReel(Integer userId) throws Exception;

}
