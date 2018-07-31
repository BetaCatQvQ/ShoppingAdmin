package com.shopping.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		ch.getCateThreeList(page);
		System.out.println(page.getData().size());
		return page.getData();
	}
	//============Ajax==================
	@RequestMapping("/listThree")
	@ResponseBody
	public Object getCategoryThree() {
		Page<CategoryThree> page = new Page<CategoryThree>();
		ch.getCateThreeList(page);
		return page;
	}
}
