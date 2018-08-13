package com.shopping.service;

import java.util.List;

import com.shopping.entity.CategoryTwo;
import com.shopping.entity.Page;

public interface CategoryTwoService {
	public void getCateTwoList(Page page);
	
	public void search(String categoryTwoName,Page page);
	
	public List<CategoryTwo> SearchByCategoryOne(Integer categoryOneId);
	
	public CategoryTwo getCateTwoById(Integer categoryTwoId);
	
	public CategoryTwo getCateTwoByIdFull(Integer categoryTwoId);
	
	public Integer addCateTwo(CategoryTwo categoryTwo);

	public Integer delCateTwo(Integer delId);

	public Integer uptCateTwo(CategoryTwo categoryTwo);
}
