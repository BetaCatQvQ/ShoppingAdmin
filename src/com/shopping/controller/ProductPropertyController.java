package com.shopping.controller;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.CategoryTwo;
import com.shopping.entity.Page;
import com.shopping.entity.ProductProperty;
import com.shopping.service.ProductPropertyService;
import com.shopping.service.ProductPropertyValueService;

@Controller
@RequestMapping("/productProperty")
public class ProductPropertyController {
	
	@Resource
	ProductPropertyService pps;
	
	@Resource
	ProductPropertyValueService ppvs;
	
	@RequestMapping("/listProductProperties")
	@ResponseBody
	public List<ProductProperty> listProductProperties(Integer categoryTwoId) {
		if (categoryTwoId == null) {
			return null;
		}
		return pps.list(categoryTwoId,null);
	}
	
	@RequestMapping("/listProductPropertiesByPage")
	@ResponseBody
	public Page<ProductProperty> listProductProperties(Integer categoryTwoId,Integer currentPage,Integer pageSize) {
		Page<ProductProperty> page = new Page();
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setRowCount(pps.listCount(categoryTwoId, page));
		List<ProductProperty> ppList = pps.list(categoryTwoId, page);
		page.setData(ppList);
		System.out.println(page);
		return page;
		
	}
	
	@RequestMapping("/deleteProductProperty") 
	@ResponseBody
	public Integer deleteProductProperty(BigInteger propertyId) {
		if (propertyId == null) {
			return 0;
		}
		Integer deleteValues = ppvs.deleteByProductProperty(propertyId);
		Integer deleteProperty = pps.delete(propertyId);
		
		if (deleteValues >= 0 && deleteProperty > 0) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/addProductProperty")
	@ResponseBody
	public Integer addProductProperty(String ppName,Integer categoryTwoId) {
		if (ppName == null || categoryTwoId == null) {
			return 0;
		}
		
		ProductProperty pp = new ProductProperty();
		pp.setProductPropertyName(ppName);
		
		CategoryTwo ct = new CategoryTwo();
		ct.setCategoryTwoId(categoryTwoId);
		
		pp.setCategoryTwo(ct);
		
		return pps.add(pp);
	}
	
	@RequestMapping("/editProductProperty")
	@ResponseBody
	public Integer editProductProperty(String ppName,Integer categoryTwoId,BigInteger ppId) {
		if (ppName == null || categoryTwoId == null || ppId == null) {
			return 0;
		}
		ProductProperty pp = new ProductProperty();
		pp.setProductPropertyName(ppName);
		pp.setProductPropertyId(ppId);
		
		CategoryTwo ct = new CategoryTwo();
		ct.setCategoryTwoId(categoryTwoId);
		pp.setCategoryTwo(ct);
		
		return pps.edit(pp);
	}
	
}
