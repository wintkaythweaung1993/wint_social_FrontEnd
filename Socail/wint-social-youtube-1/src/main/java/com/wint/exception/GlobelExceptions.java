package com.wint.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelExceptions {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Errordetails> otherExceptionHandler(Exception ue,
			WebRequest req){
		
		Errordetails error = new Errordetails(ue.getMessage(),req.getDescription(false),LocalDateTime.now());

		return new ResponseEntity<Errordetails>(error,HttpStatus.BAD_REQUEST);
			
	}
	}
