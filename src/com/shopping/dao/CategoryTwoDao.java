package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.CategoryTwo;
import com.shopping.entity.Page;

public interface CategoryTwoDao {
	public List<CategoryTwo> getCateTwo(@Param("page") Page page);
	
	public List<CategoryTwo> Search(@Param("categoryTwoName")String categoryTwoName,@Param("page") Page page);
	
	public List<CategoryTwo> SearchByCategoryOne(Integer categoryOneId);
	
	public Integer getRowsCountByPage();
	
	public Integer getRowsCountToPageByCategoryName(@Param("categoryTwoName")String categoryTwoName);
	
	public CategoryTwo getCateTwoById(@Param("categoryTwoId") Integer categoryTwoId);
	
	public CategoryTwo getCateTwoByIdFull(@Param("categoryTwoId") Integer categoryTwoId);

	public Integer addCateTwo(@Param("categoryTwo") CategoryTwo categoryTwo);

	public Integer delCateTwo(@Param("delId") Integer delId);

	public Integer uptCateTwo(@Param("categoryTwo") CategoryTwo categoryTwo);
	
}
