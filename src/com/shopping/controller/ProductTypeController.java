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
	public Integer editProductType(BigInteger ptId,String ptImage) {
		if (ptId == null) {
			return 0;
		}
		return pts.deleteProductType(ptId,ptImage);
	}
	
	@RequestMapping("/addProductType.action")
	@ResponseBody
	public Integer addProductType(BigInteger pId,String ptName,String ptImage,Float ptPrice,
			Float ptSalePrice,Integer ptRQuantity,String ptImageFile) throws IllegalStateException, IOException {
		if (pId == null || ptName == null || ptPrice == null || ptSalePrice == null ||
				ptRQuantity == null || ptImageFile == null) {
			return 0;
		}
		System.out.println(ptImageFile);
		
		if (ptImage == null) {
			ptImage = "";
		}
		ImageUtil imageUtil = new ImageUtil(ptImageFile);
		
		String suffix = null;
		String contentPath = null;
		if(ptImageFile != null){
			suffix = imageUtil.getSuffix();
			System.out.println(ptImageFile);
		}
		
		System.out.println(suffix);
		//����ԭ�����ļ�������ȡ���ļ��ĺ�׺ 
		
		System.out.println(contentPath);
		//����UUID�������µ��ļ������ǵü��Ϻ�׺
		String newFileName = SnowFlake.getId() + "." + suffix;
		//�����վ���еĸ�Ŀ¼
		String rootPath = ValTool.CONTEXT_PATH;
		//���·�������ڱ��浽���ݿ⣬�Ժ���Դ����ݿ����������ͼƬ��ʾ��ҳ��
		//    /ptImageFiles/3b4d3f722055494b88a0a0c14e60ef05.jpg
		String relativePath = "/images/productTypeImage/" + newFileName;
		//���·��
		String fullPath = rootPath + relativePath;
		
		imageUtil.writeImage(fullPath);
		
		
		System.out.println("------rootPath-----" + rootPath);
		System.out.println("------relativePath-----" + relativePath);
		System.out.println("------fullPath-----");
		
		File destFile = new File(fullPath);
		
/*		FileUtils.copyFile(srcFile, destFile);*/
		
		ProductType pt = new ProductType();
		Product p = new Product();
		p.setProductId(pId);
		pt.setProduct(p);
		pt.setProductTypeName(ptName);
		pt.setProductTypeImagePath(fullPath);
		pt.setPrice(ptPrice);
		pt.setSalePrice(ptSalePrice);
		pt.setRestQuantity(ptRQuantity);
		
		return pts.addProductType(pt);
	}
}
