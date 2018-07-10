package com.shopping.entity;

import java.math.BigInteger;
import java.sql.Date;

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

}
