package com.shopping.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.ProductImage;

public interface ProductImageService {
	
	public Integer addProductImageProductImage (ProductImage productImage,BigInteger ProductId);
	
	public List<ProductImage> getProductImageByProductId(BigInteger ProductId);
	
	public Integer deleteProductImageByProductId(BigInteger productId);
}
