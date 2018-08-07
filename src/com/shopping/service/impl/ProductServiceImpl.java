package com.shopping.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.ProductDao;
import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.service.ProductService;

/**
 * 
 * @author 焦明扬
 * 产品管理业务逻辑层实现类
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductDao pDao;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Map> getProducts(Page page, /*BigInteger productId,*/
			String productName, String firstDate, String lastDate,
			Integer CategoryId) {
		List<Map> products = pDao.getProducts(page, /*productId,*/ productName, firstDate, lastDate, CategoryId);
		for (int i = 0;i < products.size(); i++) {
			Map map = products.get(i);
			//System.out.println(map.get("productCreateDate"));
			Object pId = map.get("productId");
			Object pCreateDate = map.get("productCreateDate");
			map.put("productId", pId.toString());
			map.put("productCreateDate", pCreateDate.toString());
		}
		return products;
	}

	@Override
	public Integer add(Product product) {
		return pDao.add(product);
		}

	@Override
	public Integer update(Product product) {
		return pDao.update(product);
	}
 
	@Override
	public Integer delete(BigInteger productId) {
		return pDao.delete(productId);
	}

	@Override
	public Integer getCount(@SuppressWarnings("rawtypes") Page page, /*BigInteger productId,*/ String productName,
			String firstDate, String lastDate, Integer CategoryId) {
		return pDao.getCount(page, /*productId,*/ productName, firstDate, lastDate, CategoryId);
	}

	@Override
	public Product getProductByProductId(BigInteger productId) {
		return pDao.getProductByProductId(productId);
	}
}
