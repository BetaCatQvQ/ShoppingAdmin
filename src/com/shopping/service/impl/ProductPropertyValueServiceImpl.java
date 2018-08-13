package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductPropertyValueDao;
import com.shopping.entity.ProductPropertyValue;
import com.shopping.service.ProductPropertyValueService;

@Service
public class ProductPropertyValueServiceImpl implements ProductPropertyValueService {
	@Resource
	private ProductPropertyValueDao ppvDao;

	@Override
	public Integer deleteProductPropertyValueByProductId(BigInteger productId) {
		return ppvDao.deleteProductPropertyValueByProductId(productId);
	}

	@Override
	public Integer add(ProductPropertyValue ppValue) {
		return ppvDao.add(ppValue);
	}

	@Override
	public Integer edit(ProductPropertyValue ppValue) {
		return ppvDao.edit(ppValue);
	}

	@Override
	public Integer delete(Integer ppValueId) {
		return ppvDao.delete(ppValueId);
	}

	@Override
	public List<ProductPropertyValue> list(BigInteger productId) {
		return ppvDao.list(productId);
	}

	@Override
	public Integer deleteByProductProperty(BigInteger ppId) {
		return ppvDao.deleteByProductPropertyId(ppId);
	}
}
