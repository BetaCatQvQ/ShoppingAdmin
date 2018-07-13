package com.shopping.service.impl;

import java.util.List;

import org.junit.Test;

import com.shopping.entity.CategoryOne;
import com.shopping.service.CategoryOneService;
import com.shopping.util.SpringTool;

public class CategoryOneServiceImplTest {
	private CategoryOneService userService = SpringTool.getBean(CategoryOneServiceImpl.class);
	
	@Test
	public void testGetCateOneList() throws Exception {
		List<CategoryOne> caList = userService.getCateOneList();
		for (CategoryOne categoryOne : caList) {
			System.out.println("==========һ������==========="+categoryOne.toString());
		}
	}
	@Test
	public void testAddCateOne() throws Exception {
		CategoryOne categoryOne = new CategoryOne();
		categoryOne.setCategoryOneName("�Ҿ�");
		Integer result = userService.addCateOne(categoryOne);
			System.out.println("==========result==========="+result);
	}
	@Test
	public void testDelCateOne() throws Exception {
		Integer result = userService.delCateOne(8);
			System.out.println("==========һresult==========="+result);
	}
	@Test
	public void testUptCateOne() throws Exception {
		CategoryOne categoryOne = new CategoryOne();
		categoryOne.setCategoryOneId(9);
		categoryOne.setCategoryOneName("�ҵ�");
		Integer result = userService.uptCateOne(categoryOne);
			System.out.println("==========result==========="+result);
	}
}
