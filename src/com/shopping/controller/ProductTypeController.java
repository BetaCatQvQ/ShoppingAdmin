package com.shopping.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.entity.ProductType;
import com.shopping.service.ProductTypeService;
import com.shopping.util.CommonTools;
import com.shopping.util.ImageUtil;
import com.shopping.util.SnowFlake;
import com.shopping.util.ValTool;
@Controller
@RequestMapping("/productType")
public class ProductTypeController {
	
	@Resource
	ProductTypeService pts;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/listTypesByPage")
	@ResponseBody
	public Page<ProductType> listTypesByPage(BigInteger pId,String ptName,
			Float ptSalePriceF, Float ptSalePriceL, Integer ptQuantityF,
			Integer ptQuantityL,Integer pageNo, Integer pageSize) {
		if (pId == null || pageNo == null || pageSize == null) {
			return null;
		}
		
		@SuppressWarnings("rawtypes")
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page = pts.getProductTypesByProductId(ptName, ptSalePriceF,
				ptSalePriceL, ptQuantityF, ptQuantityL, pId, page);
		
		return page;
	}
	
	@RequestMapping("/deleteProductType.action")
	@ResponseBody
	public Integer deleteProductType(BigInteger ptId,String ptImage) {
		if (ptId == null) {
			return 0;
		}
		return pts.deleteProductType(ptId,ptImage);
	}
	
	@RequestMapping("/editProductType.action")
	@ResponseBody
	public Integer editProductType(BigInteger pId,BigInteger ptId,String ptName,Float ptPrice,
			Float ptSalePrice,Integer ptRQuantity,String ptImageFile,String ptImage) {
		if (pId == null || ptId == null || ptName == null || ptPrice == null || ptSalePrice == null ||
				ptRQuantity == null) {
			return 0;
		}
		
		String relativePath = "";
		if (ptImage != null && !(ptImage.equals(""))) {
			relativePath = ptImage;
		}
		if (ptImageFile != null && !(ptImageFile.equals(""))) {
			ImageUtil imageUtil = new ImageUtil(ptImageFile);
			
			String contentPath = ValTool.REAL_PATH;
			String suffix = imageUtil.getSuffix();
			
			System.out.println("contentPath:"+contentPath+"suffix:"+suffix);
			String newFileName = SnowFlake.getId() + "." + suffix;
			String rootPath = ValTool.CONTEXT_PATH;
			relativePath = "/images/productTypeImage/" + newFileName;
			String fullPath = rootPath + relativePath;
			
			System.out.println(ValTool.PROJECT_PATH+relativePath);
			imageUtil.writeImage(ValTool.PROJECT_PATH+relativePath);
			imageUtil.writeImage(contentPath+relativePath);
			
			if (ptImage != null && !(ptImage.equals(""))) {
				
				if (CommonTools.deleteFile(ValTool.REAL_PATH+ptImage) == false) {
					return 0;
				}
			}
		}
				
		ProductType pt = new ProductType();
		Product p = new Product();
		p.setProductId(pId);
		pt.setProduct(p);
		pt.setProductTypeId(ptId);
		pt.setProductTypeName(ptName);
		pt.setProductTypeImagePath(relativePath);
		pt.setPrice(ptPrice);
		pt.setSalePrice(ptSalePrice);
		pt.setRestQuantity(ptRQuantity);
		
		return pts.updateProductType(pt);
	}
	
	@RequestMapping("/addProductType.action")
	@ResponseBody
	public Integer addProductType(BigInteger pId,String ptName,String ptImage,Float ptPrice,
			Float ptSalePrice,Integer ptRQuantity,String ptImageFile) throws IllegalStateException, IOException {
		System.out.println("ptImageFile:"+ptImageFile);
		if (pId == null || ptName == null || ptPrice == null || ptSalePrice == null ||
				ptRQuantity == null) {
			return 0;
		}
		
		String relativePath = "";
		if (ptImageFile != null && !(ptImageFile.equals(""))) {
			ImageUtil imageUtil = new ImageUtil(ptImageFile);
			
			String contentPath = ValTool.REAL_PATH;
			String suffix = imageUtil.getSuffix();
			
			System.out.println(contentPath);
			String newFileName = SnowFlake.getId() + "." + suffix;
			String rootPath = ValTool.CONTEXT_PATH;
			relativePath = "/images/productTypeImage/" + newFileName;
			String fullPath = rootPath + relativePath;
			
			System.out.println(ValTool.PROJECT_PATH+relativePath);
			imageUtil.writeImage(ValTool.PROJECT_PATH+relativePath);
			imageUtil.writeImage(contentPath+relativePath);
		}
		
		ProductType pt = new ProductType();
		Product p = new Product();
		p.setProductId(pId);
		pt.setProduct(p);
		pt.setProductTypeName(ptName);
		pt.setProductTypeImagePath(relativePath);
		pt.setPrice(ptPrice);
		pt.setSalePrice(ptSalePrice);
		pt.setRestQuantity(ptRQuantity);
		
		return pts.addProductType(pt);
	}
}
