package com.shopping.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.Product;

/**
 * 
 * @author 焦明扬 产品管理的业务逻辑接口
 *
 */
public interface ProductService {
	// 获取所有产品,包含模糊查询以及分页
	public List<Map> getProducts(@SuppressWarnings("rawtypes") Page page,
	/* ("productId") BigInteger productId, */
	String productName, String firstDate, String lastDate, Integer CategoryId,
			String categoryType);

	public Integer add(Product product); // 添加

	public Integer update(Product product); // 修改

	public Integer delete(BigInteger productId); // 删除
	// 获取数据总数,用于分页显示

	public Integer getCount(
			@SuppressWarnings("rawtypes")Page page,
			String productName,
			String firstDate,
			String lastDate,
			Integer CategoryId,
			String categoryType);

	public Product getProductByProductId(BigInteger productId);
}
