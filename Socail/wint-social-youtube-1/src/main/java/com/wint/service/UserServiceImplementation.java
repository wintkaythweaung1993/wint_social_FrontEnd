package com.wint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wint.config.jwtProvider;
import com.wint.exception.UserException;
import com.wint.models.User;
import com.wint.repository.UserRepository;


@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository ;
	
	@Override
	public User registeredUser(User user) {
		User newUser=new User();
		newUser.setId(user.getId());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		
		
		User savedUser = userRepository.save(newUser);
		return savedUser;
	}

	@Override
	public User findUserByID(Integer userId) throws UserException{
		if (userId == null)
		{
			throw new IllegalArgumentException("UserserviceImplemanation USer ID can't be null");
		}
Optional<User> user=userRepository.findById(userId);
		
		if(user.isPresent())
		{
			return user.get();
		}
		throw new UserException("User doesn't exit with" +userId) ; 
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		return user;
	
	}
	

	@Override
	public User updateUser(User user ,Integer UserID) throws UserException {
		// TODO Auto-generated method stub
Optional<User> user1 = userRepository.findById(UserID);
		
		if (user1.isEmpty())
		{
			throw new UserException("User doesn't exit with this id " +UserID);
		}
	
		User oldUser= user1.get();
		if(user.getFirstName()!=null)
		{
			oldUser.setFirstName(user.getFirstName());
		}
		if(user.getLastName()!=null)
		{
			oldUser.setLastName(user.getLastName());
		}
		if(user.getEmail()!=null)
		{
			oldUser.setEmail(user.getEmail());
		}
		if(user.getGender()!=null)
		{
			oldUser.setGender(user.getGender());
		}
		
		User updatedUser = userRepository.save(oldUser);
		
		return updatedUser;

	}

	@Override
	public List<User> searchUser(String query) {
		// TODO Auto-generated method stub
		
		
		return userRepository.searchUser(query);
	}

	@Override
	public User followUser(Integer reqUserID, Integer userId2) throws UserException {
		User reqUser = findUserByID(reqUserID);
		User user2= findUserByID(userId2);
	
		user2.getFollowers().add(reqUser.getId());
		reqUser.getFollowings().add(user2.getId());
		
		userRepository.save(reqUser);
		userRepository.save(user2);
		
		return reqUser;
	
	}

	@Override
	public User FindUserByJwt(String jwt) {
		String email = jwtProvider.getEmailFromJwtToken(jwt);
		User user = userRepository.findByEmail(email);
		
		return user;
	}


	
}
