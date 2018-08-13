package com.shopping.dao;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.OrderItem;

public interface OrderItemDao {
	
	public OrderItem getOrderById(@Param("orderItemId") Integer orderItemId);
	
	public void updateOrderStarts(@Param("orderItem")OrderItem orderItem);
}
