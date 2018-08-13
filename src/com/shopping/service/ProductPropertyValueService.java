package com.shopping.service;

import java.math.BigInteger;
import java.util.List;

import com.shopping.entity.ProductPropertyValue;

public interface ProductPropertyValueService {
	public Integer deleteProductPropertyValueByProductId(BigInteger productId);
	
	public Integer add(ProductPropertyValue ppValue);
	
	public Integer edit(ProductPropertyValue ppValue);
	
	public Integer delete(Integer ppValueId);
	
	public Integer deleteByProductProperty(BigInteger ppId);
	
	public List<ProductPropertyValue> list(BigInteger productId);
}
