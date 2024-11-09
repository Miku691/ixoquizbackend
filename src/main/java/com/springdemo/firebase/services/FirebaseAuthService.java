package com.springdemo.firebase.services;

import org.springframework.web.multipart.MultipartFile;

import com.springdemo.firebase.dto.FirebaseLoginDto;
import com.springdemo.firebase.entity.FirebaseLoginAuth;

public interface FirebaseAuthService {
	FirebaseLoginDto signUpNewUser(FirebaseLoginAuth authObj, MultipartFile profilePic);
	String signInExistingUser(FirebaseLoginAuth authObj);
}
