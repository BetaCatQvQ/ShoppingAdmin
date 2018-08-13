package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.OrderItemDao;
import com.shopping.entity.Order;
import com.shopping.entity.OrderItem;
import com.shopping.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Resource
	private OrderItemDao oiDao;

	@Override
	public OrderItem getOrderById(Integer orderItemId) {
		return oiDao.getOrderById(orderItemId);
	}

	@Override
	public void orderItemDelivery(OrderItem orderItem) {
		oiDao.updateOrderStarts(orderItem);
	}
}
