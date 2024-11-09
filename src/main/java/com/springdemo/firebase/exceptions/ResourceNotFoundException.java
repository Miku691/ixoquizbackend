package com.springdemo.firebase.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private String key;
	private String value;
	private String message;
	
	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String key, String value, String message) {
		super( message + " " + key + " - " + value );
		this.key = key;
		this.value = value;
		this.message = message;
	}

	
}
