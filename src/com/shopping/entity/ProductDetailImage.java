package com.shopping.entity;

import java.math.BigInteger;

public class ProductDetailImage {
	/**
	 * ��Ʒ����ͼƬ���
	 */
	private BigInteger productDetailImageId;
	/**
	 * ��Ʒ
	 */
	private Product product;
	/**
	 * ��Ʒ����ͼƬ·��
	 */
	private String productDetailImagePath;

	// getter --- setter
	public BigInteger getProductDetailImageId() {
		return productDetailImageId;
	}

	public void setProductDetailImageId(BigInteger productDetailImageId) {
		this.productDetailImageId = productDetailImageId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductDetailImagePath() {
		return productDetailImagePath;
	}

	public void setProductDetailImagePath(String productDetailImagePath) {
		this.productDetailImagePath = productDetailImagePath;
	}

}
