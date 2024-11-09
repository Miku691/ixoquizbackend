package com.springdemo.firebase.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.springdemo.firebase.dto.SaveUpdateDto;
import com.springdemo.firebase.dto.CategoriesDto;
import com.springdemo.firebase.entity.Categories;
import com.springdemo.firebase.entity.FileUpload;
import com.springdemo.firebase.services.CategoriesService;
import com.springdemo.firebase.services.FileUploadService;
import com.springdemo.firebase.utility.ApiResponseStatus;
import com.springdemo.firebase.utility.ApplicationConstants;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private Firestore firestore;
	@Autowired
    private ObjectMapper objectMapper;
	@Autowired
	private FileUploadService fileUploadService;
	
	FileUpload fileUploadObj = null;
	
	@Override
	public SaveUpdateDto addCategory(Categories category, MultipartFile profileUrl) {
		DocumentReference docRef = firestore.collection(ApplicationConstants.FIREBASE_CATEGORY_COLLECTION)
				.document();
		
		try {
			fileUploadObj = this.fileUploadService.uploadDocument(profileUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		category.setProfileUrl(fileUploadObj.getFileName());
		docRef.set(category);
		
		ApiResponseStatus apiRes = new ApiResponseStatus(ApplicationConstants.STATUS_SUCCESS
				, ApplicationConstants.ADD_CATEGORY_SUCCESS_MSG);
		return new SaveUpdateDto(ApplicationConstants.FIREBASE_CATEGORY_COLLECTION, docRef.getId(), apiRes);
	}

	@Override
	public List<CategoriesDto> retrieveAllCategories() {
		List<CategoriesDto> categoriesDtoLst = new ArrayList<>();
		try {
			firestore.collection(ApplicationConstants.FIREBASE_CATEGORY_COLLECTION)
			.get()
			.get()
			.getDocuments()
			.stream().forEach(
					item -> {
						Categories categoryRes = objectMapper.convertValue(item.getData(), 
								Categories.class);
						categoriesDtoLst.add(new CategoriesDto(item.getId(), categoryRes));
					}
				);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return categoriesDtoLst;
	}

	@Override
	public CategoriesDto retrieveCategory(String categoryId) {
		try {
			this.firestore.collection(ApplicationConstants.FIREBASE_CATEGORY_COLLECTION)
			.document(categoryId).get().get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

}
