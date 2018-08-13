package com.shopping.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.CategoryOne;
import com.shopping.entity.CategoryThree;
import com.shopping.entity.Page;
import com.shopping.service.CategoryThreeService;

@Controller
@RequestMapping("/categoryThree")
public class CategoryThreeController {
	@Resource
	private CategoryThreeService ch;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<CategoryThree> getList(Page<CategoryThree> page) {
		page.setPageSize(5);
		ch.getCateThreeList(page);
		System.out.println(page.getData().size());
		return page.getData();
	}
	//============Ajax==================
	@RequestMapping("/listThree")
	@ResponseBody
	public Object getCategoryThree(Integer pageSize) {
		Page<CategoryThree> page = new Page<CategoryThree>();
		page.setPageSize(pageSize);
		ch.getCateThreeList(page);
		return page;
	}
	
	@RequestMapping("/listThreeByTwo")
	@ResponseBody
	public Object getCategoryThreeByTwo(Integer categoryTwoId) {
		return ch.SearchByCategoryTwo(categoryTwoId);
	}
	
	@RequestMapping("/getBysearch")
	@ResponseBody
	public Object getBysearch(String searchParams,Integer selectVal,Page<CategoryOne> page) {
		page.setPageSize(selectVal);
		ch.search(searchParams, page);
		return page;
	}
	
	@RequestMapping("/getCategoryThreeById")
	@ResponseBody
	public CategoryThree getCategoryThreeById(Integer categoryThreeId) {
		CategoryThree cth = ch.getCateThreeById(categoryThreeId);
		return ch.getCateThreeById(categoryThreeId);
	}
}
