package com.springdemo.firebase.utility;

public class ApiResponseStatus {
	private String status;
	private String message;
	
	
	
	public ApiResponseStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ApiResponseStatus(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
