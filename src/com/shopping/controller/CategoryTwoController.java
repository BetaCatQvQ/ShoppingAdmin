package com.shopping.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.CategoryOne;
import com.shopping.entity.CategoryTwo;
import com.shopping.entity.Page;
import com.shopping.service.CategoryTwoService;

@Controller
@RequestMapping("/categoryTwo")
public class CategoryTwoController {
	@Resource
	private CategoryTwoService ct;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<CategoryTwo> getList(Page<CategoryTwo> page){
		page.setPageSize(5);
		ct.getCateTwoList(page);
		System.out.println(page.getData().size());
		return page.getData();
	}
	//---------------ajax-------------------
	@RequestMapping("/listTwo")
	@ResponseBody
	public Object getCategoryTwo(Integer pageSize) {
		Page<CategoryTwo> page = new Page<CategoryTwo>();
		page.setPageSize(pageSize);
		return page;
	}
	
	@RequestMapping("/listTwoByOne")
	@ResponseBody
	public Object getCategoryTwoByOne(Integer categoryOneId) {
		List<CategoryTwo> twos = ct.SearchByCategoryOne(categoryOneId);
		return ct.SearchByCategoryOne(categoryOneId);
	}
	
	@RequestMapping("/getBysearch")
	@ResponseBody
	public Object getBysearch(String searchParams,Integer selectVal,Page<CategoryOne> page) {
		page.setPageSize(selectVal);
		System.out.println(searchParams);
		ct.search(searchParams, page);
		return page;
	}
	
	@RequestMapping("/getCategoryTwoById")
	@ResponseBody
	public CategoryTwo getCategoryThreeById(Integer categoryTwoId) {
		CategoryTwo cateTwo = ct.getCateTwoById(categoryTwoId);
		/*System.out.println("CategoryTwoId:");
		System.out.print(categoryTwoId);*/
		return ct.getCateTwoByIdFull(categoryTwoId);
	}
}
