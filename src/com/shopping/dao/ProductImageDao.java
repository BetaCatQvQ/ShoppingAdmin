package com.shopping.dao;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.entity.ProductImage;

public interface ProductImageDao {
	/*public List<ProductImage> getImagesByProductId(Integer productId);*/
	public List<ProductImage> getProductsAndImages(@SuppressWarnings("rawtypes") @Param("page") Page page,
			@Param("productId") BigInteger productId,
			@Param("productName") String productName,
			@Param("firstDate") Date firstDate,
			@Param("lastDate") Date lastDate,
			@Param("categoryThreeId") Integer CategoryId);
}
