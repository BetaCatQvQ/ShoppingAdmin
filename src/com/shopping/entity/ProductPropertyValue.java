package com.shopping.entity;

import java.math.BigInteger;

public class ProductPropertyValue {
	/**
	 * ��Ʒ����ֵ���
	 */
	private BigInteger productPropertyValueId;
	/**
	 * ��Ʒ����
	 */
	private ProductProperty productProperty;
	/**
	 * ��Ʒ
	 */
	private Product product;
	/**
	 * ��Ʒ����ֵ����
	 */
	private String productPropertyValueName;

	// getter --- setter
	public BigInteger getProductPropertyValueId() {
		return productPropertyValueId;
	}

	public void setProductPropertyValueId(BigInteger productPropertyValueId) {
		this.productPropertyValueId = productPropertyValueId;
	}

	public ProductProperty getProductProperty() {
		return productProperty;
	}

	public void setProductProperty(ProductProperty productProperty) {
		this.productProperty = productProperty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductPropertyValueName() {
		return productPropertyValueName;
	}

	public void setProductPropertyValueName(String productPropertyValueName) {
		this.productPropertyValueName = productPropertyValueName;
	}

}
