package com.shopping.service.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.shopping.service.OrderService;
import com.shopping.util.SpringTool;

public class OrderServiceImplTest {
	private OrderService userService = SpringTool.getBean(OrderServiceImpl.class);
	
	@Test
	public void testListOrder() throws Exception {
		List<Map> listOrder = userService.listOrder();
		for (Map map : listOrder) {
			System.out.println(map);
		}
	}
}
