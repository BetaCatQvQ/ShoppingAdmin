package com.shopping.service;

import com.shopping.entity.OrderItem;

public interface OrderItemService {
	public OrderItem getOrderById(Integer orderItemId);

	public void orderItemDelivery(OrderItem orderItem);
}
