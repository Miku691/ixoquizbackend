package com.springdemo.firebase.dto;

import com.springdemo.firebase.entity.Categories;

public class CategoriesDto {
	private String categoryId;
	private Categories category;
	
	
	
	public CategoriesDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriesDto(String categoryId, Categories category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	
	
}
