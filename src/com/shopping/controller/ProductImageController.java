package com.shopping.controller;

import java.io.File;
import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.Product;
import com.shopping.entity.ProductImage;
import com.shopping.service.ProductImageService;

@Controller
@RequestMapping("/productImage")
public class ProductImageController {
	
	@Resource
	ProductImageService piService;
	
	@RequestMapping("/getProductImagesByProductId")
	@ResponseBody
	public List<ProductImage> getProductImagesByProductId(BigInteger productId) {
			if (productId == null) {
				return null;
			}
			List<ProductImage> imageList = piService.getProductImageByProductId(productId);
			System.out.println(imageList);
		return imageList;
	}
	
	@RequestMapping("/deleteProductImage")
	@ResponseBody
	public Integer deleteProductImage(Integer productImageId) {
		return piService.delete(productImageId);
	}
	
	@RequestMapping("/addProductImage")
	@ResponseBody
	public Integer addProductImage(File imageFile,BigInteger productId) {
		
		if (imageFile == null) {
			return -1;
		}
		
		Product product = new Product();
		product.setProductId(productId);
		ProductImage productImage = new ProductImage();
		productImage.setProduct(product);
		productImage.setProductImagePath(imageFile.getPath());
		
		piService.addProductImageProductImage(productImage, productId);
		
		return 1;
	}
}
