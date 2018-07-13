package com.shopping.service;

import java.util.List;

import com.shopping.entity.CategoryOne;

public interface CategoryOneService {
	public List<CategoryOne> getCateOneList();
	
	public CategoryOne getCateOneById(Integer categoryOneId);

	public Integer addCateOne(CategoryOne categoryOne);

	public Integer delCateOne(Integer delId);

	public Integer uptCateOne(CategoryOne categoryOne);
}
