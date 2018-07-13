package com.shopping.service;

import java.util.List;

import com.shopping.entity.CategoryTwo;

public interface CategoryTwoService {
	public List<CategoryTwo> getCateTwoList();
	
	public CategoryTwo getCateTwoById(Integer categoryTwoId);
	
	public Integer addCateTwo(CategoryTwo categoryTwo);

	public Integer delCateTwo(Integer delId);

	public Integer uptCateTwo(CategoryTwo categoryTwo);
}
