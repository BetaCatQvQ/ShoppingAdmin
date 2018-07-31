package com.shopping.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.OrderDao;
import com.shopping.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao oDao;

	@Override
	public List<Map> listOrder() {
		return oDao.listOrder();
	}
}
