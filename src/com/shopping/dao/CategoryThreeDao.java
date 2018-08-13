package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.CategoryThree;
import com.shopping.entity.CategoryTwo;
import com.shopping.entity.Page;

public interface CategoryThreeDao {
	public List<CategoryThree> getCateThree(@Param("page") Page page);

	public List<CategoryThree> Search(@Param("categoryThreeName") String categoryThreeName, @Param("page") Page page);
	
	public List<CategoryThree> SearchByCategoryTwo(Integer categoryTwoId);

	public Integer getRowsCountByPage();
	
	public CategoryThree getCateThreeById(@Param("categoryThreeId") Integer categoryThreeId);

	public Integer getRowsCountToPageByCategoryName(@Param("categoryThreeName") String categoryThreeName);

	public Integer addCateThree(@Param("categoryThree") CategoryThree categoryThree);

	public Integer delCateThree(@Param("delId") Integer delId);

	public Integer uptCateThree(@Param("categoryThree") CategoryThree categoryThree);
}
