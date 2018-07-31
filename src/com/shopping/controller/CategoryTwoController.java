package com.shopping.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		ct.getCateTwoList(page);
		System.out.println(page.getData().size());
		return page.getData();
	}
	//---------------ajax-------------------
	@RequestMapping("/listTwo")
	@ResponseBody
	public Object getCategoryTwo() {
		Page<CategoryTwo> page = new Page<CategoryTwo>();
		ct.getCateTwoList(page);
		return page;
	}
}
