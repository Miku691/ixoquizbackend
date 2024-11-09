package com.springdemo.firebase.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springdemo.firebase.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseStatus> resourceNotFoundExceptionHandler(ResourceNotFoundException e){
		return new ResponseEntity<ApiResponseStatus>(new ApiResponseStatus(ApplicationConstants.STATUS_FAILED, 
				e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
}
