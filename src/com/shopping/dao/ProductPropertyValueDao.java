package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.ProductPropertyValue;

public interface ProductPropertyValueDao {
	public Integer deleteProductPropertyValueByProductId(BigInteger productId);
	
	public Integer deleteByProductPropertyId(BigInteger productPropertyId);
	
	public Integer add(ProductPropertyValue ppValue);
	
	public Integer edit(ProductPropertyValue ppValue);
	
	public Integer delete(Integer ppValueId);
	
	public List<ProductPropertyValue> list(@Param("productId") BigInteger productId);
	
}
