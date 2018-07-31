package com.shopping.service;

import com.shopping.entity.CategoryOne;
import com.shopping.entity.Page;

public interface CategoryOneService {
	public void getCateOneList(Page page);
	
	public void search(String categoryOneName,Page page);
	
	public CategoryOne getCateOneById(Integer categoryOneId);

	public Integer addCateOne(CategoryOne categoryOne);

	public Integer delCateOne(Integer delId);

	public Integer uptCateOne(CategoryOne categoryOne);
}
