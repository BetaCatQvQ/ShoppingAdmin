package com.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.CategoryThreeDao;
import com.shopping.entity.CategoryThree;
import com.shopping.service.CategoryThreeService;

@Service
public class CategoryThreeServiceImpl implements CategoryThreeService{
	@Resource
	private CategoryThreeDao ctDao;

	@Override
	public List<CategoryThree> getCateThreeList() {
		return ctDao.getCateThree();
	}

	@Override
	public Integer addCateThree(CategoryThree categoryThree) {
		return ctDao.addCateThree(categoryThree);
	}

	@Override
	public Integer delCateThree(Integer delId) {
		return ctDao.delCateThree(delId);
	}

	@Override
	public Integer uptCateThree(CategoryThree categoryThree) {
		return ctDao.uptCateThree(categoryThree);
	}
}
