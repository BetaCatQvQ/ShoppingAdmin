package com.shopping.controller;

import java.util.List;

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

	@RequestMapping("/search?categoryOneName")
	public List<CategoryOne> search(String categoryOneName, Page<CategoryOne> page) {
		co.search(categoryOneName, page);
		return page.getData();
	}

	// =======================Ajax==========================
	@RequestMapping("/listOne")
	@ResponseBody
	public Object getCategoryOne() {
		Page<CategoryOne> page = new Page<CategoryOne>();
		co.getCateOneList(page);
		return page;
	}
}
