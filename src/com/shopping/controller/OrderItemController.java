package com.shopping.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.OrderItem;
import com.shopping.service.OrderItemService;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	@Resource
	private OrderItemService oi;
	 @RequestMapping("/orderItemDelivery/{orderItemId}")
	public String orderItemDelivery(@PathVariable("orderItemId") Integer orderItemId) {
		if (orderItemId != null) {
			System.out.println(orderItemId);
			OrderItem orderItem = oi.getOrderById(orderItemId);
			Integer starts = orderItemId +1;
			System.out.println(starts);
			orderItem.setStatus(starts);
			oi.orderItemDelivery(orderItem);
	}
		return "redirect:/order/listOrder.action";
}
}
