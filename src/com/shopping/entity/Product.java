package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Product {
	/**
	 * ��Ʒ���
	 */
	private BigInteger productId;
	/**
	 * ��������
	 */
	private CategoryThree categoryThree;
	/**
	 * ��Ʒ����
	 */
	private String productName;
	/**
	 * ��Ʒ�ϼ�����
	 */
	private Date productCreateDate;
	/**
	 * ���һ,��Ʒ����
	 */
	/*private Set<ProductType> productTypes = new HashSet<ProductType>();*/
	/**
	 * һ��һ,��ƷͼƬ
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
