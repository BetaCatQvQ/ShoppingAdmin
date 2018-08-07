package com.shopping.service.impl;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductPropertyValueDao;
import com.shopping.service.ProductPropertyValueService;

@Service
public class ProductPropertyValueServiceImpl implements ProductPropertyValueService {
	@Resource
	private ProductPropertyValueDao ppvDao;

	@Override
	public Integer deleteProductPropertyValueByProductId(BigInteger productId) {
		return ppvDao.deleteProductPropertyValueByProductId(productId);
	}
}
