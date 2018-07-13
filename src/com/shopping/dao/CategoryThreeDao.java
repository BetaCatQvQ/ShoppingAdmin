package com.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.CategoryThree;

public interface CategoryThreeDao {
	public List<CategoryThree> getCateThree();

	public Integer addCateThree(@Param("categoryThree") CategoryThree categoryThree);

	public Integer delCateThree(@Param("delId") Integer delId);

	public Integer uptCateThree(@Param("categoryThree") CategoryThree categoryThree);
}
