package com.shopping.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.service.ProductService;
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Resource 
	private ProductService productService;
	
	@RequestMapping("/searchProducts")
	@ResponseBody
	public Object getProductsByPage() {
		
		/*Page page = 
		List<Product> productList = productService.getProducts(page, productId, productName, firstDate, lastDate, CategoryId);*/
		return null;
	}
}
