package com.shopping.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.Page;
import com.shopping.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource
	private OrderService os;

	@RequestMapping("/listOrder")
	public String listORder(Model model, Page<Map> page) {
		page.setPageSize(2);
		os.listOrder(null, null, null, null, null, null, page);
		model.addAttribute("orders", page);
		return "listOrder";
	}
	@RequestMapping("/updateOrder")
	public String updateOrder(String status) {
		
		return "redirect:/listOrder.action";
	}
}
