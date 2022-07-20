package com.lucifer.lab.services;

import com.lucifer.lab.payloads.CategoryDto;



public interface CategoryService {
	
	//Create
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//Update
	
	CategoryDto updatCategory(CategoryDto categoryDto, Integer categoryId);
	
	//Delete
	
	void deleteCategory(Integer categoryId);
	
	//GET
	
	CategoryDto getCategory(Integer categoryId);
	//GET ALL
	
	java.util.List<CategoryDto> getCategories();

	
}
