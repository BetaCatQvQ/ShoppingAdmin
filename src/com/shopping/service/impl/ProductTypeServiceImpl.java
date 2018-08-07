package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductTypeDao;
import com.shopping.entity.Page;
import com.shopping.entity.ProductType;
import com.shopping.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Resource
	private ProductTypeDao ptDao;

	@Override
	public Integer getProductCountByProductId(Integer id) {
		return ptDao.getProductCountByProductId(id);
	}

	@Override
	public List<ProductType> getProductTypesByProductId(String productTypeName,
			Float fSalePrice, Float lSalePrice, Integer fRestQuantity,
			Integer lRestQuantity, Date firstDate, Date lastDate,
			BigInteger productId, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addProductType(ProductType productType) {
		return ptDao.addProductType(productType);
	}

	@Override
	public Integer updateProductType(ProductType productType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteProductType(Integer productTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteProductTypeByProductId(BigInteger productId) {
		return ptDao.deleteProductTypeByProductId(productId);
	}
}
