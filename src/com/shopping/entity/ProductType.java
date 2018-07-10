package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;

public class ProductType {
	/**
	 * ��Ʒ���ͱ��
	 */
	private BigInteger productTypeId;
	/**
	 * ��Ʒ
	 */
	private Product product;
	/**
	 * ��Ʒ��������
	 */
	private String productTypeName;
	/**
	 * �۸�
	 */
	private Float price;
	/**
	 * �Żݼ۸�
	 */
	private Float salePrice;
	/**
	 * ʣ������
	 */
	private Integer restQuantity;
	/**
	 * ��Ʒ����ͼƬ·��
	 */
	private String productTypeImagePath;
	/**
	 * �ϼ�ʱ��
	 */
	private Date productTypeCreateDate;

	// getter --- setter
	public BigInteger getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(BigInteger productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getRestQuantity() {
		return restQuantity;
	}

	public void setRestQuantity(Integer restQuantity) {
		this.restQuantity = restQuantity;
	}

	public String getProductTypeImagePath() {
		return productTypeImagePath;
	}

	public void setProductTypeImagePath(String productTypeImagePath) {
		this.productTypeImagePath = productTypeImagePath;
	}

	public Date getProductTypeCreateDate() {
		return productTypeCreateDate;
	}

	public void setProductTypeCreateDate(Date productTypeCreateDate) {
		this.productTypeCreateDate = productTypeCreateDate;
	}

}
