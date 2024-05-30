package com.wint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.wint.models.Reel;
import com.wint.models.User;
import com.wint.service.ReelService;
import com.wint.service.UserService;

@RestController
public class ReelController {
	
	@Autowired
	private ReelService reelService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/reels")
	public Reel createReels(@RequestBody Reel reel,@RequestHeader ("Authorization")String jwt)
	{
		User reqUser= userService.FindUserByJwt(jwt);
		Reel createdReels = reelService.createReel(reel, reqUser);
		return createdReels;
	}
	@GetMapping("/api/reels")
	public List<Reel>findAllReels()
	{
		List<Reel> reels = reelService.FindAllReels();
		return reels;
	}
	@GetMapping("/api/reels/user/{userId}")
	public List<Reel>findUserReels(@PathVariable Integer userId)throws Exception 
	{
		List<Reel> reels = reelService.findUserReel(userId);
		return reels;
	}
	

}
