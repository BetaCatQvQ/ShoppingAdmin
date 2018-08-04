package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.CategoryOne;
import com.shopping.entity.Page;

public interface CategoryOneDao {
	public List<CategoryOne> getCateOne(@Param("page") Page page);
	
	public List<CategoryOne> Search(@Param("categoryOneName")String categoryOneName,@Param("page") Page page);
	
	public Integer getRowsCountByPage();
	
	public Integer getRowsCountToPageByCategoryName(@Param("categoryOneName")String categoryOneName);
	
	public CategoryOne getCateOneById(@Param("categoryOneId") Integer categoryOneId);

	public Integer addCateOne(@Param("categoryOne") CategoryOne categoryOne);

	public Integer delCateOne(@Param("delId") Integer delId);

	public Integer uptCateOne(@Param("categoryOne") CategoryOne categoryOne);
	
}
