package com.shopping.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.CategoryOne;
import com.shopping.service.CategoryOneService;

@Controller
@RequestMapping("/categoryOne")
public class CategoryOneController {
	@Resource
	private CategoryOneService coService;
	@RequestMapping("/list")
	public String getList(Model model) {
		List<CategoryOne> coList = coService.getCateOneList();
		model.addAttribute("coLsit", coList);
		return "";
	}
}
