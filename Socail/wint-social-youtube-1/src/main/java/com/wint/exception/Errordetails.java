package com.wint.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Errordetails {

	private String message;
	private String error;
	private LocalDateTime timeStamp;
	
	
	
	
	
}
