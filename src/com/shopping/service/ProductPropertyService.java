package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.Page;
import com.shopping.entity.ProductProperty;

public interface ProductPropertyService {
	public Integer add(ProductProperty productProperty);
	
	public Integer edit(ProductProperty productProperty);
	
	public Integer delete(BigInteger propertyId);
	
	public List<ProductProperty> list(Integer categoryTwoId,Page page);
	
	public Integer listCount(Integer categoryTwoId,Page page);
}
