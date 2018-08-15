package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductDetailImageDao;
import com.shopping.entity.Product;
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

	@Override
	public Integer delete(BigInteger productImageDetailId) {
		return pdiDao.delete(productImageDetailId);
	}

	@Override
	public Integer add(String imagePath, BigInteger pId) {
		ProductDetailImage pdi = new ProductDetailImage();
		Product p = new Product();
		p.setProductId(pId);
		pdi.setProduct(p);
		pdi.setProductDetailImagePath(imagePath);
		
		return pdiDao.add(pdi);
	}
	
	
}
