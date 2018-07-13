package com.shopping.service.impl;

import java.util.Date;
import java.util.List;

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
	public List<Product> getProducts(@SuppressWarnings("rawtypes") Page page, Integer productId,
			String productName, Date firstDate, Date lastDate,
			Integer CategoryId) {
		return pDao.getProducts(page, productId, productName, firstDate, lastDate, CategoryId);
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
	public Integer delete(Integer productId) {
		return pDao.delete(productId);
	}

	@Override
	public Integer getCount(@SuppressWarnings("rawtypes") Page page, Integer productId, String productName,
			Date firstDate, Date lastDate, Integer CategoryId) {
		return pDao.getCount(page, productId, productName, firstDate, lastDate, CategoryId);
	}
}
