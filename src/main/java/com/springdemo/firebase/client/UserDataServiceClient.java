package com.springdemo.firebase.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springdemo.firebase.dto.FirebaseLoginDto;



@Service
public class UserDataServiceClient {
	@Value("${userDataService.url}")
	private String userDataServiceUrl;
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	public void storeUserData(FirebaseLoginDto userDetails) {
		String url = userDataServiceUrl + "/user";
		restTemplate.postForObject(url, userDetails, Void.class);
	}
}
