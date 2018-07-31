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
	public List<ProductImage> getProductsAndImages(Page page,
			BigInteger productId, String productName, Date firstDate,
			Date lastDate, Integer CategoryId) {
		// TODO Auto-generated method stub
		return piDao.getProductsAndImages(page, productId, productName, firstDate, lastDate, CategoryId);
	}

/*	@Override
	public List<ProductImage> getImagesByProductId(Integer productId) {
		return piDao.getImagesByProductId(productId);
	}*/
	
}
