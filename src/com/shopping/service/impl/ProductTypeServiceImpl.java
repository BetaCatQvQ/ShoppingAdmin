package com.shopping.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.shopping.dao.ProductTypeDao;
import com.shopping.entity.Page;
import com.shopping.entity.Product;
import com.shopping.entity.ProductType;
import com.shopping.service.ProductTypeService;
import com.shopping.util.CommonTools;
import com.shopping.util.SnowFlake;
import com.shopping.util.ValTool;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Resource
	private ProductTypeDao ptDao;

	@Override
	public Integer getProductCountByProductId(Integer id) {
		return ptDao.getProductCountByProductId(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getProductTypesByProductId(String productTypeName,
			Float fSalePrice, Float lSalePrice, Integer fRestQuantity,
			Integer lRestQuantity,/* Date firstDate, Date lastDate,*/
			BigInteger productId, Page page) {
		
		Product p = new Product();
		p.setProductId(productId);
		
		ProductType ptF = new ProductType();
		ptF.setProductTypeName(productTypeName);
		ptF.setSalePrice(fSalePrice);
		ptF.setRestQuantity(fRestQuantity);
		ptF.setProduct(p);
		
		ProductType ptL = new ProductType();
		ptL.setSalePrice(lSalePrice);
		ptL.setRestQuantity(lRestQuantity);
		
		page.setRowCount(ptDao.getCountByProductId(ptF, ptL, page));
		List<Map> ptList = ptDao.getProductTypesByProductId(ptF, ptL, page);
		
		for (int i = 0;i < ptList.size(); i++) {
			Map map = ptList.get(i);
			//System.out.println(map.get("productCreateDate"));
			Object pId = map.get("productId");
			Object ptCreateDate = map.get("productTypeCreateDate");
			map.put("productId", pId.toString());
			map.put("productTypeCreateDate", ptCreateDate.toString());
		}
		
		page.setData(ptList);
		
		return page;
	}

	@Override
	public Integer addProductType(ProductType productType) {
		
		/*String selectPath = productType.getProductTypeImagePath();
		String suffix = selectPath.substring(selectPath.lastIndexOf(".") + 1);
		String imagePath = "/images/productTypeImage/"+SnowFlake.getId()+"."+suffix;
		
		System.out.println(selectPath);
		System.out.println(suffix);
		System.out.println(imagePath);
		
		try {
			//File oriFile = new File(selectPath);
			File destFile = new File("CONTEXT_PATH"+imagePath);
			FileUtils.copyFile(ptImageFile, destFile);
			productType.setProductTypeImagePath(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return ptDao.addProductType(productType);
	}

	@Override
	public Integer updateProductType(ProductType productType) {
		return ptDao.updateProductType(productType);
	}

	@Override
	public Integer deleteProductType(BigInteger productTypeId,String pImage) {
		if (pImage != null && !pImage.equals("")) {
			CommonTools.deleteFile(ValTool.PROJECT_PATH+pImage);
			if (CommonTools.deleteFile(ValTool.REAL_PATH+pImage) == false) {
				return 0;
			}
		}
		return ptDao.deleteProductType(productTypeId);
	}

	@Override
	public Integer deleteProductTypeByProductId(BigInteger productId) {
		return ptDao.deleteProductTypeByProductId(productId);
	}
}
