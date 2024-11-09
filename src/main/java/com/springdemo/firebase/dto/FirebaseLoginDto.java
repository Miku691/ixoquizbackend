package com.springdemo.firebase.dto;

public class FirebaseLoginDto {
	private String uId;
	private String email;
	private String profilePicture;
	private String displayName;
	
	
	
	public FirebaseLoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FirebaseLoginDto(String uId, String email, String profilePicture, String displayName) {
		super();
		this.uId = uId;
		this.email = email;
		this.profilePicture = profilePicture;
		this.displayName = displayName;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}
