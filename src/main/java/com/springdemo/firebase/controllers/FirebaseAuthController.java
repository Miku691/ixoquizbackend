package com.springdemo.firebase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springdemo.firebase.dto.FirebaseLoginDto;
import com.springdemo.firebase.entity.FirebaseLoginAuth;
import com.springdemo.firebase.services.FirebaseAuthService;

@RestController
@RequestMapping(path = "api/quiz/")
public class FirebaseAuthController {

	@Autowired
	FirebaseAuthService firebaseAuthService;
	
	@PostMapping("signup")
	public ResponseEntity<FirebaseLoginDto> createNewUser(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("profilePicture") MultipartFile profilePicture,
			@RequestParam("displayName") String displayName
			){
		FirebaseLoginAuth authUser = new FirebaseLoginAuth(null, email, password, displayName, null);
		FirebaseLoginDto authId = firebaseAuthService.signUpNewUser(authUser, profilePicture);
		
		return new ResponseEntity<FirebaseLoginDto>(authId, HttpStatus.OK);
	}
	
	@PostMapping("signin")
	public ResponseEntity<String> signInWithEmail(@RequestBody FirebaseLoginAuth authUser){
		return new ResponseEntity<String>(this.firebaseAuthService.signInExistingUser(authUser), HttpStatus.OK);
	}
}
