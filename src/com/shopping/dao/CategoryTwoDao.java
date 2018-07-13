package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.CategoryOne;
import com.shopping.entity.CategoryTwo;

public interface CategoryTwoDao {
	public List<CategoryTwo> getCateTwo();
	
	public CategoryTwo getCateTwoById(@Param("categoryTwoId") Integer categoryTwoId);

	public Integer addCateTwo(@Param("categoryTwo") CategoryTwo categoryTwo);

	public Integer delCateTwo(@Param("delId") Integer delId);

	public Integer uptCateTwo(@Param("categoryTwo") CategoryTwo categoryTwo);
}
