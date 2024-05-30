package com.wint.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wint.exception.UserException;
import com.wint.models.User;
import com.wint.repository.UserRepository;
import com.wint.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public User CreateUser(@RequestBody User user)
	{	
		
		User savedUser = userService.registeredUser(user);
		return savedUser;
	}
	
	
	@GetMapping("/api/users")
	public List<User> getUser()
	{	
		List<User> users=userRepository.findAll();
		return users;
		
	}
	
	public User getUser(@PathVariable("userId")Integer id)
	{
		
		
		
		return null; 
	}
	
	
	
	@GetMapping("/api/users/{id}")
	public User getUserById(@PathVariable("id")Integer id)throws UserException
	{
	User user=userService.findUserByID(id);
	return user;
	
	}
	
	
	
	@PutMapping("/api/users")
	public User UpdateUser(@RequestHeader("Authorization") String jwt,@RequestBody User user )throws UserException
	{
	User reqUser = userService.FindUserByJwt(jwt);
	 User UpdatedUser = userService.updateUser(user, reqUser.getId());
	 return UpdatedUser;
	}
	
	@PutMapping("/api/users/follow/{userId2}")
	public User followUserHandler(@RequestHeader("Authorization")String jwt,@PathVariable Integer userId2) throws UserException {
		User reqUser =userService.FindUserByJwt(jwt);
		User user= userService.followUser(reqUser.getId(), userId2);
		return user;
	}
	
	
	
	@GetMapping("/api/users/search")
	public List<User> searchUser(@RequestParam ("query")String query){
		List<User> users = userService.searchUser(query);
		
		return users;
	}
	@GetMapping("/api/users/profile")
	public User getUserFromToken(@RequestHeader("Authorization")String jwt)
	{
		//System.out.println("jwt --------" + jwt);
		User user = userService.FindUserByJwt(jwt);
		user.setPassword(null);
		return user;
	}
	
	
	
	
	
	
	@DeleteMapping("api/users/{userId}")
	public String DeleteUser(@PathVariable ("userId")Integer userId) throws UserException
	{
		 Optional<User> user = userRepository.findById(userId);
		 if (user.isEmpty())
			{
				throw new UserException("User doesn't exit with this id " +userId);
			}
		 userRepository.delete(user.get());
		 return "User deleted succesfully with id "+ userId;
		
	}
}
