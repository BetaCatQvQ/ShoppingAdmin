package com.shopping.service;

import com.shopping.entity.CategoryThree;
import com.shopping.entity.Page;

public interface CategoryThreeService {
	public void getCateThreeList(Page page);
	
	public void search(String categoryThreeName,Page page);

	public Integer addCateThree(CategoryThree categoryThree);

	public Integer delCateThree(Integer delId);

	public Integer uptCateThree(CategoryThree categoryThree);
}
