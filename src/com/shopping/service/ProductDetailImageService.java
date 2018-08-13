package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageService {
	public Integer deleteProductDetailImageByProductId(BigInteger productId);
	
	public List<ProductDetailImage> getProductDetailImageByProductId(BigInteger productId);
	
	public Integer delete(Integer productImageDetailId);
}
