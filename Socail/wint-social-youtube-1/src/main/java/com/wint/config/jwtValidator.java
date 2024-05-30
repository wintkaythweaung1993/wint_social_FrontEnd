package com.wint.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jwtValidator extends OncePerRequestFilter {


	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		String jwt = request.getHeader(jwtConstant.JWT_HEADER);
		
		if(jwt!= null)
		{
			try
			{
				String email = jwtProvider.getEmailFromJwtToken(jwt);
				List<GrantedAuthority> authoritities = new ArrayList<>();
				Authentication authentication = new UsernamePasswordAuthenticationToken(email,null, authoritities);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			catch(Exception ex)
			{
				throw new BadCredentialsException("Invalid Token....");
				
			}
			
		}
//		else
//		{
//			throw new BadCredentialsException("Please provide a valid token");
//		}
			
		filterChain.doFilter(request, response);
		}
	
	}



