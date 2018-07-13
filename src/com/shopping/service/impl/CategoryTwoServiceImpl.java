package com.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.CategoryTwoDao;
import com.shopping.entity.CategoryTwo;
import com.shopping.service.CategoryTwoService;
@Service
public class CategoryTwoServiceImpl implements CategoryTwoService{
	@Resource
	private CategoryTwoDao ctDao;

	@Override
	public List<CategoryTwo> getCateTwoList() {
		return ctDao.getCateTwo();
	}

	@Override
	public Integer addCateTwo(CategoryTwo categoryTwo) {
		return ctDao.addCateTwo(categoryTwo);
	}

	@Override
	public Integer delCateTwo(Integer delId) {
		return ctDao.delCateTwo(delId);
	}

	@Override
	public Integer uptCateTwo(CategoryTwo categoryTwo) {
		return ctDao.uptCateTwo(categoryTwo);
	}

	@Override
	public CategoryTwo getCateTwoById(Integer categoryTwoId) {
		return ctDao.getCateTwoById(categoryTwoId);
	}
}
