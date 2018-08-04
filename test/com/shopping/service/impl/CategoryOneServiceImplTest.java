package com.shopping.service.impl;

import org.junit.Test;

import com.shopping.entity.CategoryOne;
import com.shopping.entity.Page;
import com.shopping.service.CategoryOneService;
import com.shopping.util.SpringTool;

public class CategoryOneServiceImplTest {
	private CategoryOneService userService = SpringTool.getBean(CategoryOneServiceImpl.class);
	
	@Test
	public void testGetCateOneList() throws Exception {
		Page<CategoryOne> page = new Page<CategoryOne>();
		page.setPageSize(5);
		userService.getCateOneList(page);
		System.out.println(page.getData());
	}
	@Test
	public void testAddCateOne() throws Exception {
		CategoryOne categoryOne = new CategoryOne();
		categoryOne.setCategoryOneName("家具");
		Integer result = userService.addCateOne(categoryOne);
			System.out.println("==========result==========="+result);
	}
	@Test
	public void testDelCateOne() throws Exception {
		Integer result = userService.delCateOne(8);
			System.out.println("==========一result==========="+result);
	}
	@Test
	public void testUptCateOne() throws Exception {
		CategoryOne categoryOne = new CategoryOne();
		categoryOne.setCategoryOneId(9);
		categoryOne.setCategoryOneName("家电");
		Integer result = userService.uptCateOne(categoryOne);
			System.out.println("==========result==========="+result);
	}
	@Test
	public void testSearch() throws Exception {
		String categoryOneName = "电";
		Page<CategoryOne> cPage = new Page<CategoryOne>();
		cPage.setPageSize(5);
		userService.search(categoryOneName,cPage);
		System.out.println(cPage.getData());
		System.out.println(cPage.getFirstIndex());
	}
}
