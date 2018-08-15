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
import com.shopping.util.CommonTools;
import com.shopping.util.ImageUtil;
import com.shopping.util.SnowFlake;
import com.shopping.util.ValTool;

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
	public Integer deleteProductImage(Integer productImageId,String imagePath) {
		CommonTools.deleteFile(ValTool.PROJECT_PATH+imagePath);
		if (CommonTools.deleteFile(ValTool.REAL_PATH+imagePath) == false) {
			return 0;
		}
		return piService.delete(productImageId);
	}
	
	@RequestMapping("/addProductImage")
	@ResponseBody
	public Integer addProductImage(BigInteger pId,String imageFile) {
		
		if (imageFile == null) {
			return 0;
		}
		
		String relativePath = "";
		if (imageFile != null && !(imageFile.equals(""))) {
			ImageUtil imageUtil = new ImageUtil(imageFile);
			
			String contentPath = ValTool.REAL_PATH;
			String suffix = imageUtil.getSuffix();
			
			System.out.println(contentPath);
			String newFileName = SnowFlake.getId() + "." + suffix;
			String rootPath = ValTool.CONTEXT_PATH;
			relativePath = "/images/productImage/" + newFileName;
			
			System.out.println("===================================================");
			System.out.println("ProjectPath:"+ValTool.PROJECT_PATH+relativePath);
			System.out.println("contentPath:"+contentPath+relativePath);
			System.out.println("===================================================");
			imageUtil.writeImage(ValTool.PROJECT_PATH+relativePath);
			imageUtil.writeImage(contentPath+relativePath);
		}
		
		Product product = new Product();
		product.setProductId(pId);
		ProductImage productImage = new ProductImage();
		productImage.setProduct(product);
		productImage.setProductImagePath(relativePath);
		
		Integer add = piService.addProductImageProductImage(productImage, pId);
		
		return add;
	}
}
