package com.shopping.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.CategoryThree;
import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.entity.ProductType;
import com.shopping.service.ProductDetailImageService;
import com.shopping.service.ProductImageService;
import com.shopping.service.ProductPropertyValueService;
import com.shopping.service.ProductService;
import com.shopping.service.ProductTypeService;
import com.shopping.util.SnowFlake;

@Controller
@Component
@RequestMapping("/product")
public class ProductController {

	@Resource
	private ProductService productService;

	@Resource
	private ProductImageService productImageService;
	
	@Resource
	private ProductTypeService productTypeService;
	
	@Resource
	private ProductDetailImageService productDetailImageService;
	
	@Resource
	private ProductPropertyValueService productPropertyValueService;

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
	public Integer addProduct(String productName,Integer categoryThreeId) {
		Product product = new Product();
		CategoryThree categoryThree = new CategoryThree();
		categoryThree.setCategoryThreeId(categoryThreeId);
		product.setProductId(BigInteger.valueOf(SnowFlake.getId()));
		product.setProductName(productName);
		product.setCategoryThree(categoryThree);
		product.setProductCreateDate(new Date());
		
		ProductType productType = new ProductType();
		productType.setProduct(product);
		productType.setProductTypeName(productName);
		productType.setProductTypeImagePath("");
		productType.setPrice((float)-1);
		productType.setSalePrice((float)-1);
		productType.setRestQuantity(0);
		
		Integer insertResult = productService.add(product);
		Integer insertResultType = productTypeService.addProductType(productType);
		if (insertResult != 1 || insertResultType != 1) {
			return null;
		}
		return insertResult;
	}
	
	@RequestMapping("/editProduct")
	@ResponseBody
	public Integer editProduct(/*Integer currentPage,Integer pageSize,*/ BigInteger productId,
			String productName/*,Integer categoryThreeId*/) {
		
		System.out.println(productId);
		System.out.println(productName);
		
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductCreateDate(new Date());
		
		Integer insertResult = productService.update(product);
		return insertResult;
	}
	
	@RequestMapping("/deleteProduct")
	@ResponseBody
	public Integer deleteProduct(BigInteger productId,
			String productName,Integer categoryThreeId) {
		
		Integer productTypeResult = productTypeService.deleteProductTypeByProductId(productId);
		Integer productImageResult = productImageService.deleteProductImageByProductId(productId);
		Integer productDetailImageResult = productDetailImageService.deleteProductDetailImageByProductId(productId);
		Integer productPropertyValueResult = productPropertyValueService.deleteProductPropertyValueByProductId(productId);
		Integer productResult = productService.delete(productId);
		
		if (productResult != 1 ||
			productTypeResult < 0	||
			productImageResult < 0 	 ||
			productDetailImageResult < 0 ||
			productPropertyValueResult < 0) {
			
			return null;
			
		}
		
		return productResult;
	}
	
	@RequestMapping("/getProductByProductId")
	@ResponseBody
	public Product getProductByProductId(BigInteger productId) {
		Product product = productService.getProductByProductId(productId);
		System.out.println("getProductByProductId");
		System.out.println(productId);
		System.out.println(product);
		return product;
	}
}
