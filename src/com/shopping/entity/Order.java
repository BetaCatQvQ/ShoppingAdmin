package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;

public class Order {
	/**
	 * �������
	 */
	private BigInteger orderId;
	/**
	 * �û�
	 */
	private User user;
	/**
	 * ��������ʱ��
	 */
	private Date orderCreateDate;

	// getter --- setter
	public BigInteger getOrderId() {
		return orderId;
	}

	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderCreateDate() {
		return orderCreateDate;
	}

	public void setOrderCreateDate(Date orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
	}

}
