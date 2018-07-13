package com.shopping.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.Product;

/**
 * 
 * @author 焦明扬
 * 产品管理的业务逻辑接口
 *
 */
public interface ProductService {
	// 获取所有产品,包含模糊查询以及分页
	public List<Product> getProducts(@SuppressWarnings("rawtypes") @Param("page") Page page,
			@Param("productId") Integer productId,
			@Param("productName") String productName,
			@Param("firstDate") Date firstDate,
			@Param("lastDate") Date lastDate,
			@Param("categoryThreeId") Integer CategoryId);

	public Integer add(Product product); // 添加

	public Integer update(Product product); // 修改

	public Integer delete(Integer productId); // 删除
	// 获取数据总数,用于分页显示

	public Integer getCount(@SuppressWarnings("rawtypes") @Param("page") Page page,
			@Param("product") Integer productId,
			@Param("productName") String productName,
			@Param("firstDate") Date firstDate,
			@Param("lastDate") Date lastDate,
			@Param("categoryThreeId") Integer CategoryId);
}
