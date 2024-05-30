package com.wint.response;

public class ApiResponse {
	private String message;
	private boolean status;
	/**
	 * 
	 */
	
	/**
	 * @param b 
	 * @param message2 
	 * @param message
	 * @param status
	 */
	
	
	public String getMessage() {
		return message;
	}
	/**
	 * @param message
	 * @param status
	 */
	public ApiResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	

}
