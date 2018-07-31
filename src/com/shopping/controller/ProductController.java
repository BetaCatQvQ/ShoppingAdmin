package com.shopping.controller;

import java.math.BigInteger;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.CategoryThree;
import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.service.ProductImageService;
import com.shopping.service.ProductService;
import com.shopping.util.SnowFlake;

@Controller
@Component
@RequestMapping("/product")
public class ProductController {

	@Resource
	private ProductService productService;

	@Resource
	private ProductImageService productImageService;

	@RequestMapping("/showProducts")
	public String showProducts(Model model) {
		
		Page page = new Page();
		page.setPageNo(1);
		/*page.setPageCount(totalPage);*/	
		page.setPageSize(10);
		page.setRowCount(productService.getCount(page, /* searchId, */
				null, null, null, 1));
		page.setData(productService.getProducts(page, /* searchId, */null,
				null, null, 1));
		
		model.addAttribute("page", page);
		System.out.println("showProducts");
		return "listProduct";
	}

	@RequestMapping("/searchProducts")
	@ResponseBody
	public Page<Product> getProductsByPage(String searchName, String firstDate, String lastDate,
			Integer categoryId, Integer currentPage,Integer pageSize) {
		
		/*Date startTime = CommonTools.getDateFromString(firstDate,
				"YYYY-MM-dd HH:mm");
		Date finalTime = CommonTools.getDateFromString(lastDate,
				"YYYY-MM-dd HH:mm");*/
		
		System.out.println("searchProducts");
		
		Page page = new Page();
		page.setPageNo(currentPage);
		/*page.setPageCount(totalPage);*/	
		page.setPageSize(pageSize);
		page.setRowCount(productService.getCount(page, /* searchId, */
				searchName, firstDate, lastDate, categoryId));
		page.setData(productService.getProducts(page, /* searchId, */searchName,
				firstDate, lastDate, categoryId));
		return page;
	}

	@RequestMapping("/addProduct")
	@ResponseBody
	public Integer addProduct(Integer currentPage,Integer pageSize,
			String productName,Integer categoryThreeId) {
		Product product = new Product();
		CategoryThree categoryThree = new CategoryThree();
		categoryThree.setCategoryThreeId(categoryThreeId);
		product.setProductId(BigInteger.valueOf(SnowFlake.getId()));
		product.setProductName(productName);
		product.setCategoryThree(categoryThree);
		product.setProductCreateDate(new Date());
		
		Integer insertResult = productService.add(product);
		return insertResult;
	}
	
	@RequestMapping("/editProduct")
	@ResponseBody
	public Integer editProduct(Integer currentPage,Integer pageSize,Integer productId,
			String productName,Integer categoryThreeId) {
		Product product = new Product();
		CategoryThree categoryThree = new CategoryThree();
		categoryThree.setCategoryThreeId(categoryThreeId);
		product.setProductId(BigInteger.valueOf(productId));
		product.setProductName(productName);
		product.setCategoryThree(categoryThree);
		//product.setProductCreateDate(new Date());
		
		Integer insertResult = productService.update(product);
		return insertResult;
	}
	
	@RequestMapping("/deleteProduct")
	@ResponseBody
	public Integer deleteProduct(Integer currentPage,Integer pageSize,Integer productId,
			String productName,Integer categoryThreeId) {
		Product product = new Product();
		
		Integer insertResult = productService.delete(BigInteger.valueOf(productId));
		return insertResult;
	}
	
	@RequestMapping("/getProductByProductId")
	@ResponseBody
	public Product getProductByProductId(Integer productId) {
		Product product = productService.getProductByProductId(BigInteger.valueOf(productId));
		return product;
	}
}
