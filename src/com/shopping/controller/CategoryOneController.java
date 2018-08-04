package com.shopping.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shopping.entity.CategoryOne;
import com.shopping.entity.Page;
import com.shopping.service.CategoryOneService;

@Controller
@RequestMapping("/categoryOne")
@SessionAttributes("user")
public class CategoryOneController {
	@Resource
	private CategoryOneService co;

	@RequestMapping("/list")
	public String getList(Model model, Page<CategoryOne> page) {
		page.setPageSize(5);
		co.getCateOneList(page);
		model.addAttribute("page", page);
		return "listCategory";
	}

	@RequestMapping("/editCategory")
	public String editCategoryOne(Integer id,Model model) {
		model.addAttribute("categoryOne", co.getCateOneById(id));
		return "editCategory";
	}
	@RequestMapping("/uptCategoryOne")
	public String uptCategoryOne(CategoryOne categoryOne) {
		System.out.println(categoryOne.toString());
		co.uptCateOne(categoryOne);
		return "redirect:/categoryOne/list.action";
	}

	// =======================Ajax==========================
	@RequestMapping("/listOne")
	@ResponseBody
	public Object getCategoryOne(Integer pageSize) {
		Page<CategoryOne> page = new Page<CategoryOne>();
		page.setPageSize(pageSize);
		co.getCateOneList(page);
		return page;
	}
	@RequestMapping("/getBysearch")
	@ResponseBody
	public Object getBysearch(String searchParams,Integer selectVal,Integer pageNo,Page<CategoryOne> page) {
		page.setPageSize(selectVal);
		page.setPageNo(pageNo);
		co.search(searchParams, page);
		return page;
	}
}
