package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductPropertyDao;
import com.shopping.entity.Page;
import com.shopping.entity.ProductProperty;
import com.shopping.service.ProductPropertyService;

@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {
	@Resource
	private ProductPropertyDao ppDao;

	@Override
	public Integer add(ProductProperty productProperty) {
		return ppDao.add(productProperty);
	}

	@Override
	public Integer edit(ProductProperty productProperty) {
		return ppDao.edit(productProperty);
	}

	@Override
	public Integer delete(BigInteger propertyId) {
		return ppDao.delete(propertyId);
	}

	@Override
	public List<ProductProperty> list(Integer categoryTwoId, Page page) {
		return ppDao.list(categoryTwoId, page);
	}

	@Override
	public Integer listCount(Integer categoryTwoId, Page page) {
		return ppDao.listCount(categoryTwoId, page);
	}
}
