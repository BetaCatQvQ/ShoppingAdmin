package com.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.CategoryTwoDao;
import com.shopping.entity.CategoryOne;
import com.shopping.entity.CategoryTwo;
import com.shopping.entity.Page;
import com.shopping.service.CategoryTwoService;
@Service
public class CategoryTwoServiceImpl implements CategoryTwoService{
	@Resource
	private CategoryTwoDao ctDao;

	@Override
	public void getCateTwoList(Page page) {
		Integer rowCount = ctDao.getRowsCountByPage();
		page.setRowCount(rowCount);
		List<CategoryTwo> categoryTwos=  ctDao.getCateTwo(page);
		page.setData(categoryTwos);;
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

	@Override
	public void search(String categoryTwoName,Page page) {
		Integer rowCount = ctDao.getRowsCountToPageByCategoryName(categoryTwoName);
		page.setRowCount(rowCount);
		List<CategoryTwo> categoryTwos=  ctDao.Search(categoryTwoName, page);
		page.setData(categoryTwos);

	}
}
