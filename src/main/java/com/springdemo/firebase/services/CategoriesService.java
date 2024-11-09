package com.springdemo.firebase.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springdemo.firebase.dto.SaveUpdateDto;
import com.springdemo.firebase.dto.CategoriesDto;
import com.springdemo.firebase.entity.Categories;

public interface CategoriesService {
	SaveUpdateDto addCategory(Categories category, MultipartFile profileUrl);
	
	List<CategoriesDto> retrieveAllCategories();
	
	CategoriesDto retrieveCategory(String categoryId);
}
