package com.wint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wint.config.jwtProvider;
import com.wint.models.User;
import com.wint.repository.UserRepository;
import com.wint.request.LoginRequest;
import com.wint.response.AuthResponse;
import com.wint.service.CustomerUserDetailService;
import com.wint.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerUserDetailService customeruserdetailService;
	
	//auth/sign in
	@PostMapping("/signup")
	public AuthResponse CreateUser(@RequestBody User user) throws Exception
	{	
	    User isExist= userRepository.findByEmail(user.getEmail());
	    if(isExist!= null)
	    {
	    	throw new Exception("Email was already used with another account");
	    }
		
			User newUser=new User();
			
			newUser.setEmail(user.getEmail());
			newUser.setFirstName(user.getFirstName());
			newUser.setLastName(user.getLastName());
			newUser.setPassword(passwordEncoder.encode(user.getPassword()));
			User savedUser = userRepository.save(newUser);
			Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),savedUser.getPassword() );
			String token = jwtProvider.generateToken(authentication);
			AuthResponse res = new AuthResponse(token,"Register Success");
			
			return res;
	}
	@PostMapping("/signin")
	public AuthResponse signin (@RequestBody LoginRequest loginRequest)
	{
		Authentication authentication= authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		String token =jwtProvider.generateToken(authentication);
		AuthResponse res = new AuthResponse(token, "Login Success");
		return res;
	}
	
	private Authentication authenticate(String email, String password) {
		// TODO Auto-generated method stub
		
		UserDetails userDetail = customeruserdetailService.loadUserByUsername(email);
		
		if(userDetail  == null)
		{
			throw new BadCredentialsException ("Invalid Username");
		}
		if(!passwordEncoder.matches(password, userDetail.getPassword()))
		{
			throw new BadCredentialsException("Password doesn't match");
		}			
		return new UsernamePasswordAuthenticationToken(userDetail, null,userDetail.getAuthorities());
	}

}
