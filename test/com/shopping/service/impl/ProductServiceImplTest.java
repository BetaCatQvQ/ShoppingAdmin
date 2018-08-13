package com.shopping.service.impl;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.service.ProductService;
import com.shopping.util.SpringTool;

public class ProductServiceImplTest {
	private ProductService userService = SpringTool.getBean(ProductServiceImpl.class);
	
	
	@Test
	public void testShow() {
		Page<Map> page = new Page<Map>();
		page.setPageSize(5);
		page.setPageNo(1);
		//List<Map> productList = userService.getProducts(page, "f", null, null, 1);
		
		for (Map map : productList) {
			System.out.println(map);
		}
	}
	
	/*@Test
	public void add() {
		Product product = new Product();
		CategoryThree categoryThree = new CategoryThree();
		categoryThree.setCategoryThreeId(1);
		product.setProductId(BigInteger.valueOf(SnowFlake.getId()));
		product.setCategoryThree(categoryThree);
		product.setProductName("≈¨±»—«≤‚ ‘AAA");
		product.setProductCreateDate(new Date());
		userService.add(product);
	}*/
	
	/*@Test
	public void update() {
		
	}*/
}
