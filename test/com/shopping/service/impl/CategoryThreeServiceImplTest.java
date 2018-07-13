package com.shopping.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.shopping.entity.CategoryThree;
import com.shopping.entity.CategoryTwo;
import com.shopping.service.CategoryThreeService;
import com.shopping.service.CategoryTwoService;
import com.shopping.util.SpringTool;

public class CategoryThreeServiceImplTest {
	private CategoryTwoService userServicetwo = SpringTool.getBean(CategoryTwoServiceImpl.class);
	private CategoryThreeService userServiceThree = SpringTool.getBean(CategoryThreeServiceImpl.class);

	@Test
	public void testGetCateThreeList() throws Exception {
		List<CategoryThree> ctThrees = userServiceThree.getCateThreeList();
		for (CategoryThree categoryThree : ctThrees) {
			System.out.println("===========Three=============" + categoryThree.toString());
		}
	}

	@Test
	public void testAddCateThree() throws Exception {
		CategoryTwo categoryTwo = userServicetwo.getCateTwoById(3);
		CategoryThree categoryThree = new CategoryThree();
		categoryThree.setCategoryThreeName("≤‚ ‘");
		categoryThree.setCategoryTwo(categoryTwo);
		Integer result = userServiceThree.addCateThree(categoryThree);
		System.out.println("===========Three=============" + categoryThree.toString());
	}

	@Test
	public void testUptCateThree() throws Exception {
		CategoryTwo categoryTwo = userServicetwo.getCateTwoById(3);
		CategoryThree categoryThree = new CategoryThree();
		categoryThree.setCategoryThreeName("≤‚ ‘");
		categoryThree.setCategoryTwo(categoryTwo);
		categoryThree.setCategoryThreeId(3);
		Integer result = userServiceThree.uptCateThree(categoryThree);
		System.out.println("===========Three=============" + result);
	}

	@Test
	public void testDelCateThree() throws Exception {
		Integer result = userServiceThree.delCateThree(4);
		System.out.println(result);
	}
}
