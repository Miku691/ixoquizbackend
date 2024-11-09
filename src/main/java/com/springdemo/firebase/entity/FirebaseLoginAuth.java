package com.springdemo.firebase.entity;

public class FirebaseLoginAuth {
	private String uid;
	private String email;
	private String password;
	private String displayName;
	private String profilePicture;
	
	public FirebaseLoginAuth() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FirebaseLoginAuth(String uid, String email, String password, String displayName, String profilePicture) {
		super();
		this.uid = uid;
		this.email = email;
		this.password = password;
		this.displayName = displayName;
		this.profilePicture = profilePicture;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	
}
