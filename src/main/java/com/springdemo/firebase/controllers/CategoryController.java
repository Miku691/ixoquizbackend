package com.springdemo.firebase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springdemo.firebase.dto.SaveUpdateDto;
import com.springdemo.firebase.dto.CategoriesDto;
import com.springdemo.firebase.entity.Categories;
import com.springdemo.firebase.services.CategoriesService;

@RestController
@RequestMapping(path = "api/quiz/")
public class CategoryController {

	@Autowired
	CategoriesService categoriesService;
	
	//CREATE CATEGORY
	@PostMapping("category")
	public ResponseEntity<SaveUpdateDto> createCategory(
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("profileUrl") MultipartFile profileUrl
			){
		Categories category = new Categories(title, description, "default.png");
		SaveUpdateDto addDto = this.categoriesService.addCategory(category , profileUrl);
		return new ResponseEntity<SaveUpdateDto>(addDto, HttpStatus.CREATED);
	}
	
	//LIST OF ALL CATEGORUES
	@GetMapping("category")
	public ResponseEntity<List<CategoriesDto>> retrieveAllCategory(){
		return new ResponseEntity<List<CategoriesDto>>(this.categoriesService.retrieveAllCategories(),
				HttpStatus.OK);
	}
}
