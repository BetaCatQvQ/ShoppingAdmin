package com.shopping.entity;

import java.math.BigInteger;

public class ProductImage {
	/**
	 * ��ƷͼƬ���
	 */
	private BigInteger productImageId;
	/**
	 * ��Ʒ
	 */
	private Product product;
	/**
	 * ��ƷͼƬ·��
	 */
	private String productImagePath;

	// getter --- setter
	public BigInteger getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(BigInteger productImageId) {
		this.productImageId = productImageId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

}
