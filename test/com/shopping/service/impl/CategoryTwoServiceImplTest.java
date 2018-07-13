package com.shopping.service.impl;

import java.util.List;

import org.junit.Test;

import com.shopping.entity.CategoryOne;
import com.shopping.entity.CategoryTwo;
import com.shopping.service.CategoryOneService;
import com.shopping.service.CategoryTwoService;
import com.shopping.util.SpringTool;

public class CategoryTwoServiceImplTest {
	private CategoryTwoService userServicetwo = SpringTool.getBean(CategoryTwoServiceImpl.class);
	private CategoryOneService userServiceone = SpringTool.getBean(CategoryOneServiceImpl.class);
	
	@Test
	public void testGetCateTwoList() throws Exception {
		List<CategoryTwo> caList = userServicetwo.getCateTwoList();
		for (CategoryTwo categoryTwo : caList) {
			System.out.println("==========��������==========="+categoryTwo.toString());
		}
	}
	@Test
	public void testAddCateTwo() throws Exception {
		CategoryOne categoryOne = userServiceone.getCateOneById(1);
		System.out.println(categoryOne);
		CategoryTwo categoryTwo = new CategoryTwo();
		categoryTwo.setCategoryOne(categoryOne);
		categoryTwo.setCategoryTwoName("���");
		Integer result = userServicetwo.addCateTwo(categoryTwo);
		System.out.println("==========result==========="+result);
	}
	@Test
	public void testDelCateTwo() throws Exception {
		Integer result = userServicetwo.delCateTwo(4);
		System.out.println("==========result==========="+result);
	}
	@Test
	public void testUptCateTwo() throws Exception {
		
		CategoryTwo categoryTwo = new CategoryTwo();

		categoryTwo.setCategoryTwoName("�����");
		categoryTwo.setCategoryTwoId(3);
		Integer result = userServicetwo.uptCateTwo(categoryTwo);
		System.out.println("==========result==========="+result);
	}
}
