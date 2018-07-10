package com.shopping.entity;

import java.math.BigInteger;
import java.sql.Date;

public class Review {
	/**
	 * ���۱��
	 */
	private BigInteger reviewId;
	/**
	 * �û�
	 */
	private User user;
	/**
	 * ������
	 */
	private OrderItem orderItem;
	/**
	 * ��������
	 */
	private String content;
	/**
	 * ��������
	 */
	private Date reviewCreateDate;

	// getter --- setter
	public BigInteger getReviewId() {
		return reviewId;
	}

	public void setReviewId(BigInteger reviewId) {
		this.reviewId = reviewId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReviewCreateDate() {
		return reviewCreateDate;
	}

	public void setReviewCreateDate(Date reviewCreateDate) {
		this.reviewCreateDate = reviewCreateDate;
	}

}
