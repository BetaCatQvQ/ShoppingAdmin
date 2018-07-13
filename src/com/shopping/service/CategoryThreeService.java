package com.shopping.service;

import java.util.List;

import com.shopping.entity.CategoryThree;

public interface CategoryThreeService {
	public List<CategoryThree> getCateThreeList();

	public Integer addCateThree(CategoryThree categoryThree);

	public Integer delCateThree(Integer delId);

	public Integer uptCateThree(CategoryThree categoryThree);
}
