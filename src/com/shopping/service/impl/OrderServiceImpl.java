package com.shopping.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.OrderDao;
import com.shopping.entity.Page;
import com.shopping.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao oDao;

	@Override
	public void listOrder(Integer orderId, Integer orderItemId, Date startPayTime, Date endPayTime,
			Date startConfirmTime, Date endConfirmTime, Page page) {
		Integer rowCount = oDao.getRowsCountByPage(orderId, orderItemId, startPayTime, endPayTime, startConfirmTime, endConfirmTime);
		page.setRowCount(rowCount);
		List<Map> maps = oDao.listOrder(orderId, orderItemId, startPayTime, endPayTime, startConfirmTime, endConfirmTime, page);
		page.setData(maps);
	}

	
}
