package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.ProductProperty;

public interface ProductPropertyDao {
	public Integer add(ProductProperty productProperty);
	
	public Integer edit(ProductProperty productProperty);
	
	public Integer delete(BigInteger propertyId);
	
	public List<ProductProperty> list(@Param("categoryTwoId") Integer categoryTwoId,@Param("page")Page page);
	
	public Integer listCount(@Param("categoryTwoId") Integer categoryTwoId,@Param("page")Page page);
	
}
