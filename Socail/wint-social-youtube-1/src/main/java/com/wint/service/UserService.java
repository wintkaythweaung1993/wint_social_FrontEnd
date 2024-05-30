package com.wint.service;

import java.util.List;

import com.wint.exception.UserException;
import com.wint.models.User;

public interface UserService {

	public User registeredUser(User user);
	
	public User findUserByID(Integer UserID) throws UserException;
	
	public User findUserByEmail(String email);
	
	public  User followUser(Integer UserID1,Integer UserID2) throws UserException  ;
	
	public User updateUser(User user,Integer UserID) throws UserException;
	
	public List<User> searchUser(String query) ;
	
	public User FindUserByJwt(String jwt);
}
