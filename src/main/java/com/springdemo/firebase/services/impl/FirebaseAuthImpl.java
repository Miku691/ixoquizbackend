package com.springdemo.firebase.services.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.springdemo.firebase.client.UserDataServiceClient;
import com.springdemo.firebase.dto.FirebaseLoginDto;
import com.springdemo.firebase.entity.FileUpload;
import com.springdemo.firebase.entity.FirebaseLoginAuth;
import com.springdemo.firebase.services.FileUploadService;
import com.springdemo.firebase.services.FirebaseAuthService;

@Service
public class FirebaseAuthImpl implements FirebaseAuthService {

	@Autowired
	FirebaseAuth firebaseAuth;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	UserDataServiceClient userDataServiceClient;
	
	@Override
	public FirebaseLoginDto signUpNewUser(FirebaseLoginAuth authObj, MultipartFile profilePic) {
		UserRecord user = null;
		FirebaseLoginDto userData = new FirebaseLoginDto();
		try {
			FileUpload fileUpload = this.fileUploadService.uploadDocument(profilePic);
			
			UserRecord.CreateRequest userRequest = new UserRecord.CreateRequest()
					.setEmail(authObj.getEmail())
					.setPassword(authObj.getPassword());
			user = firebaseAuth.createUser(userRequest);
			
			authObj.setUid(user.getUid());
			authObj.setProfilePicture(fileUpload.getFileName());
//			set data to user
			userData.setuId(authObj.getUid());
			userData.setEmail(authObj.getEmail());
			userData.setDisplayName(authObj.getDisplayName());
			userData.setProfilePicture(authObj.getProfilePicture());
			
			userDataServiceClient.storeUserData(userData);
			
		} catch (FirebaseAuthException | IOException e) {
			e.printStackTrace();
		}
		System.out.println(user);
		
		return userData;
	}

	@Override
	public String signInExistingUser(FirebaseLoginAuth authObj) {
		String uId = null;
		try {
			UserRecord userRecord = firebaseAuth.getInstance().getUserByEmail(authObj.getEmail());
			uId = userRecord.getUid();
		} catch (FirebaseAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uId;
	}

}
