package com.springdemo.firebase.dto;

import com.springdemo.firebase.utility.ApiResponseStatus;

public class SaveUpdateDto {
	private String collectionName;
	private String id;
	private ApiResponseStatus apiResponseStatus;
	
	public SaveUpdateDto() {
		super();
	}
	
	public SaveUpdateDto(String collectionName, String id, ApiResponseStatus apiResponseStatus) {
		super();
		this.collectionName = collectionName;
		this.id = id;
		this.apiResponseStatus = apiResponseStatus;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ApiResponseStatus getApiResponseStatus() {
		return apiResponseStatus;
	}

	public void setApiResponseStatus(ApiResponseStatus apiResponseStatus) {
		this.apiResponseStatus = apiResponseStatus;
	}
		
}
