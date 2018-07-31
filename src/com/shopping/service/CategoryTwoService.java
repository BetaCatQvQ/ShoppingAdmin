package com.shopping.service;

import com.shopping.entity.CategoryTwo;
import com.shopping.entity.Page;

public interface CategoryTwoService {
	public void getCateTwoList(Page page);
	
	public void search(String categoryTwoName,Page page);
	
	public CategoryTwo getCateTwoById(Integer categoryTwoId);
	
	public Integer addCateTwo(CategoryTwo categoryTwo);

	public Integer delCateTwo(Integer delId);

	public Integer uptCateTwo(CategoryTwo categoryTwo);
}
