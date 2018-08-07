package com.shopping.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.ProductType;

public interface ProductTypeService {
	public Integer getProductCountByProductId(Integer id);

	public List<ProductType> getProductTypesByProductId(
			@Param("productTypeName") String productTypeName,
			@Param("fSalePrice") Float fSalePrice,
			@Param("lSalePrice") Float lSalePrice,
			@Param("fRestQuantity") Integer fRestQuantity,
			@Param("lRestQuantity") Integer lRestQuantity,
			@Param("firstDate") Date firstDate,
			@Param("lastDate") Date lastDate,
			@Param("productId") BigInteger productId, @Param("page") Page page);
	
	public Integer addProductType(ProductType productType);
	public Integer updateProductType(ProductType productType);
	public Integer deleteProductType(Integer productTypeId);
	
	public Integer deleteProductTypeByProductId(BigInteger productId);
}
