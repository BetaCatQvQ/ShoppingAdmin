package com.shopping.service.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.shopping.entity.Page;
import com.shopping.service.OrderService;
import com.shopping.util.SpringTool;

public class OrderServiceImplTest {
	private OrderService userService = SpringTool.getBean(OrderServiceImpl.class);
	
	@Test
	public void testListOrder() throws Exception {
		Page<Map> page = new Page<Map>();
		page.setPageSize(5);
	    userService.listOrder(null, null, null, null, null, null, page);
		for (Map map : page.getData()) {
			System.out.println(map);
		}
	}
}
