package com.shopping.controller;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.Product;
import com.shopping.entity.ProductDetailImage;
import com.shopping.entity.ProductImage;
import com.shopping.service.ProductDetailImageService;
import com.shopping.util.CommonTools;
import com.shopping.util.ImageUtil;
import com.shopping.util.SnowFlake;
import com.shopping.util.ValTool;

@Controller
@RequestMapping("/productDetailImage")
public class ProductDetailImageController {
	@Resource
	ProductDetailImageService pdiService;
	
	@RequestMapping("/getProductDetailImagesByProductId")
	@ResponseBody
	public List<ProductDetailImage> getProductDetailImagesByProductId(BigInteger productId) {
			if (productId == null) {
				return null;
			}
			List<ProductDetailImage> imageList = pdiService.getProductDetailImageByProductId(productId);
		return imageList;
	}
	
	@RequestMapping("/deleteProductDetailImage")
	@ResponseBody
	public Integer deleteProductDetailImage(BigInteger productDetailImageId,String imagePath) {
		System.out.println("p");
		CommonTools.deleteFile(ValTool.PROJECT_PATH+imagePath);
		System.out.println(ValTool.REAL_PATH+imagePath);
		if (CommonTools.deleteFile(ValTool.REAL_PATH+imagePath) == false) {
		System.out.println("SSSSS\n");
			return 0;
		}
		return pdiService.delete(productDetailImageId);
	}
	
	@RequestMapping("/addProductDetailImage")
	@ResponseBody
	public Integer addProductDetailImage(BigInteger pId,String imageFile) {
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
			relativePath = "/images/productDetailImage/" + newFileName;
			
			System.out.println(ValTool.PROJECT_PATH+relativePath);
			imageUtil.writeImage(ValTool.PROJECT_PATH+relativePath);
			imageUtil.writeImage(contentPath+relativePath);
		}
		
		Product product = new Product();
		product.setProductId(pId);
		ProductImage productImage = new ProductImage();
		productImage.setProduct(product);
		productImage.setProductImagePath(relativePath);
		
		Integer add = pdiService.add(relativePath, pId); 
		
		return add;
	}
}
