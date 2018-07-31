package com.shopping.service.impl;

import java.math.BigInteger;
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

	@Override
	public List<Map> getProducts(@SuppressWarnings("rawtypes") Page page, /*BigInteger productId,*/
			String productName, String firstDate, String lastDate,
			Integer CategoryId) {
		return pDao.getProducts(page, /*productId,*/ productName, firstDate, lastDate, CategoryId);
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
