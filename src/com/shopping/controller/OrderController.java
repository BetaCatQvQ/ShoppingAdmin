package com.shopping.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.service.OrderService;
@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource
	private OrderService os;
	@RequestMapping("/listOrder")
	public String listORder(Model model) {
		List<Map> listOrder = os.listOrder();
		model.addAttribute("orders", listOrder);
		return "listOrder";
	}
}
