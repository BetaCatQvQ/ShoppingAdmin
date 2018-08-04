package com.shopping.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shopping.entity.Page;

public interface OrderService {
	public void listOrder(Integer orderId, Integer orderItemId, Date startPayTime, Date endPayTime,
			Date startConfirmTime, Date endConfirmTime, Page page);
}
