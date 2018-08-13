package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.ProductDetailImage;

public interface ProductDetailImageDao {
	
	public Integer deleteProductDetailImageByProductId(BigInteger productId);
	
	public List<ProductDetailImage> getProductDetailImageByProductId(BigInteger productId);
	
	public Integer delete(Integer productImageDetailId);
	
}
