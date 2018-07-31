package com.shopping.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.CategoryThreeDao;
import com.shopping.entity.CategoryOne;
import com.shopping.entity.CategoryThree;
import com.shopping.entity.CategoryTwo;
import com.shopping.entity.Page;
import com.shopping.service.CategoryThreeService;

@Service
public class CategoryThreeServiceImpl implements CategoryThreeService{
	@Resource
	private CategoryThreeDao ctDao;

	@Override
	public void getCateThreeList(Page page) {
		Integer rowCount = ctDao.getRowsCountByPage();
		page.setRowCount(rowCount);
		List<CategoryThree> categoryThrees=  ctDao.getCateThree(page);
		page.setData(categoryThrees);
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

	@Override
	public void search(String categoryThreeName,Page page) {
		Integer rowCount = ctDao.getRowsCountToPageByCategoryName(categoryThreeName);
		page.setRowCount(rowCount);
		List<CategoryThree> categoryThrees=  ctDao.getCateThree(page);
		page.setData(categoryThrees);
	}
}
