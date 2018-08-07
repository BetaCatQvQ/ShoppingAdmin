package com.shopping.controller;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.entity.ProductImage;
import com.shopping.service.ProductImageService;

@Controller
@RequestMapping("/productImage")
public class ProductImageController {
	
	@Resource
	ProductImageService piService;
	
	@RequestMapping("/getProductImagesByProductId")
	public List<ProductImage> getProductImagesByProductId(BigInteger productId) {
			if (productId == null) {
				return null;
			}
			List<ProductImage> imageList = piService.getProductImageByProductId(productId);
		return imageList;
	}
}
