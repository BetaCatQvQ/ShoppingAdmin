package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductImageDao;
import com.shopping.entity.Page;
import com.shopping.entity.ProductImage;
import com.shopping.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Resource
	private ProductImageDao piDao;

	@Override
	public Integer addProductImageProductImage(ProductImage productImage,
			BigInteger ProductId) {
		return piDao.addProductImage(productImage, ProductId);
	}

	@Override
	public List<ProductImage> getProductImageByProductId(BigInteger ProductId) {
		return piDao.getProductImageByProductId(ProductId);
	}

	@Override
	public Integer deleteProductImageByProductId(BigInteger productId) {
		return piDao.deleteProductImageByProductId(productId);
	}

	@Override
	public Integer delete(Integer productImageId) {
		return piDao.delete(productImageId);
	}
	
}
