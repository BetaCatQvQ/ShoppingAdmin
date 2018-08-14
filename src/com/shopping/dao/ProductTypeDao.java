package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.ProductType;

public interface ProductTypeDao {
	public Integer getProductCountByProductId(Integer id);

	public List<Map> getProductTypesByProductId(
			@Param("ptF") ProductType ptF,@Param("ptL") ProductType ptL, @Param("page") Page page);
	
	public Integer addProductType(ProductType productType);
	public Integer updateProductType(ProductType productType);
	public Integer deleteProductType(BigInteger productTypeId);
	
	public Integer deleteProductTypeByProductId(BigInteger productId);
	
	public Integer getCountByProductId(
			@Param("ptF") ProductType ptF,@Param("ptL") ProductType ptL, @Param("page") Page page);
}
