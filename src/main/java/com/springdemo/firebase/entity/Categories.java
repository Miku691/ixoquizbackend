package com.springdemo.firebase.entity;

public class Categories {
	private String title;
	private String description;
	private String profileUrl;
	
	
	
	public Categories() {
		super();
	}
	public Categories(String title, String description, String profileUrl) {
		super();
		this.title = title;
		this.description = description;
		this.profileUrl = profileUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
}
