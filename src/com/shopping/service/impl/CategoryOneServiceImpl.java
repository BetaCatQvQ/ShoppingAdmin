package com.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.CategoryOneDao;
import com.shopping.entity.CategoryOne;
import com.shopping.service.CategoryOneService;

@Service
public class CategoryOneServiceImpl implements CategoryOneService{
	@Resource
	private CategoryOneDao coDao;

	@Override
	public List<CategoryOne> getCateOneList() {
		return coDao.getCateOne();
	}

	@Override
	public Integer addCateOne(CategoryOne categoryOne) {
		return coDao.addCateOne(categoryOne);
	}

	@Override
	public Integer delCateOne(Integer delId) {
		return coDao.delCateOne(delId);
	}

	@Override
	public Integer uptCateOne(CategoryOne categoryOne) {
		return coDao.uptCateOne(categoryOne);
	}

	@Override
	public CategoryOne getCateOneById(Integer categoryOneId) {
		return coDao.getCateOneById(categoryOneId);
	}
}
