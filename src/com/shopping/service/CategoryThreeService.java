package com.shopping.service;

import java.util.List;

import com.shopping.entity.CategoryThree;
import com.shopping.entity.CategoryTwo;
import com.shopping.entity.Page;

public interface CategoryThreeService {
	public void getCateThreeList(Page page);
	
	public void search(String categoryThreeName,Page page);
	
	public List<CategoryThree> SearchByCategoryTwo(Integer categoryTwoId);
	
	public CategoryThree getCateThreeById(Integer categoryThreeId);

	public Integer addCateThree(CategoryThree categoryThree);

	public Integer delCateThree(Integer delId);

	public Integer uptCateThree(CategoryThree categoryThree);
}
