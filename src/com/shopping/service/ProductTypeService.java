package com.shopping.service;

import java.io.File;
import java.math.BigInteger;

import com.shopping.entity.Page;
import com.shopping.entity.ProductType;

public interface ProductTypeService {
	public Integer getProductCountByProductId(Integer id);

	@SuppressWarnings("rawtypes")
	public Page getProductTypesByProductId(
			String productTypeName,
			Float fSalePrice,
			Float lSalePrice,
			Integer fRestQuantity,
			Integer lRestQuantity,
			/*("firstDate") Date firstDate,
			("lastDate") Date lastDate,*/
			BigInteger productId,Page page);
	
	public Integer addProductType(ProductType productType);
	public Integer updateProductType(ProductType productType);
	public Integer deleteProductType(BigInteger productTypeId,String pImage);
	
	public Integer deleteProductTypeByProductId(BigInteger productId);
}
