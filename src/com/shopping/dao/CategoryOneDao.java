package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.CategoryOne;

public interface CategoryOneDao {
	public List<CategoryOne> getCateOne();
	
	public CategoryOne getCateOneById(@Param("categoryOneId") Integer categoryOneId);

	public Integer addCateOne(@Param("categoryOne") CategoryOne categoryOne);

	public Integer delCateOne(@Param("delId") Integer delId);

	public Integer uptCateOne(@Param("categoryOne") CategoryOne categoryOne);
}
