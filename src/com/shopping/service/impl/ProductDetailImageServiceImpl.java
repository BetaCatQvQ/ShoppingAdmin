package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductDetailImageDao;
import com.shopping.entity.ProductDetailImage;
import com.shopping.service.ProductDetailImageService;

@Service
public class ProductDetailImageServiceImpl implements ProductDetailImageService {
	@Resource
	private ProductDetailImageDao pdiDao;

	@Override
	public Integer deleteProductDetailImageByProductId(BigInteger productId) {
		return pdiDao.deleteProductDetailImageByProductId(productId);
	}

	@Override
	public List<ProductDetailImage> getProductDetailImageByProductId(
			BigInteger productId) {
		return pdiDao.getProductDetailImageByProductId(productId);
	}
	
	
}
