package com.shopping.controller;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entity.Product;
import com.shopping.entity.ProductProperty;
import com.shopping.entity.ProductPropertyValue;
import com.shopping.service.ProductPropertyValueService;

@Controller
@RequestMapping("/productPropertyValue")
public class ProductPropertyValueController {
	
	@Resource
	ProductPropertyValueService ppvs;
	
	@RequestMapping("/showProductPropertyValues")
	@ResponseBody
	public List<ProductPropertyValue> showProductPropertyValues(BigInteger productId) {
		if (productId == null) {
			return null;
		}
		return ppvs.list(productId);
	}
	
	@RequestMapping("/deleteProductPropertyValue") 
	@ResponseBody
	public Integer deleteProductProperty(Integer productPropertyValueId) {
		if (productPropertyValueId == null) {
			return 0;
		}
		return ppvs.delete(productPropertyValueId);
	}
	
	@RequestMapping("addProductPropertyValue")
	@ResponseBody
	public Integer addProductPropertyValue(String valueName,BigInteger productId,BigInteger ppId) {
		if (valueName == null || productId == null) {
			return 0;
		}
		ProductPropertyValue ppv = new ProductPropertyValue();
		Product p = new Product();
		p.setProductId(productId);
		
		ProductProperty pp = new ProductProperty();
		pp.setProductPropertyId(ppId);
		
		ppv.setProductPropertyValueName(valueName);
		ppv.setProduct(p);
		ppv.setProductProperty(pp);
		System.out.println("--------------------------");
		System.out.println(ppv);
		return ppvs.add(ppv);
	}
	
	@RequestMapping("editProductPropertyValue")
	@ResponseBody
	public Integer editProductPropertyValue(BigInteger valueId,String valueName/*,BigInteger productId*/,BigInteger ppId) {
		if (valueName == null || ppId == null || valueId == null) {
			return 0;
		}
		ProductPropertyValue ppv = new ProductPropertyValue();
		/*Product p = new Product();
		p.setProductId(productId);*/
		
		ProductProperty pp = new ProductProperty();
		pp.setProductPropertyId(ppId);
		
		ppv.setProductPropertyValueId(valueId);
		ppv.setProductPropertyValueName(valueName);
		
		/*ppv.setProduct(p);*/
		ppv.setProductProperty(pp);
		
		return ppvs.edit(ppv);
	}
}
