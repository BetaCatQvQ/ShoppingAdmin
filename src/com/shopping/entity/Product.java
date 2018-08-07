package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Product {
	/**
	 * 产品编号
	 */
	private BigInteger productId;
	/**
	 * 三级分类
	 */
	private CategoryThree categoryThree;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品上架日期
	 */
	private Date productCreateDate;
	/**
	 * 多对一,产品类型
	 */
	/*private Set<ProductType> productTypes = new HashSet<ProductType>();*/
	/**
	 * 一对一,产品图片
	 */
	/*private ProductImage productImage;*/

	// getter --- setter
	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public CategoryThree getCategoryThree() {
		return categoryThree;
	}

	public void setCategoryThree(CategoryThree categoryThree) {
		this.categoryThree = categoryThree;
	}
	
	/*public Set<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(Set<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public ProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}*/

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getProductCreateDate() {
		return productCreateDate;
	}

	public void setProductCreateDate(Date productCreateDate) {
		this.productCreateDate = productCreateDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryThree="
				+ categoryThree + ", productName=" + productName
				+ ", productCreateDate=" + productCreateDate + "]";
	}
}
