package com.shopping.entity;

import java.math.BigInteger;
import java.util.Date;

public class User {
	/**
	 * �û����
	 */
	private BigInteger userId;
	/**
	 * �û���
	 */
	private String userName;
	/**
	 * �û�����
	 */
	private String userPwd;
	/**
	 * �û���ɫ
	 */
	private Integer role;
	/**
	 * ��������
	 */
	private Date userCreateDate;

	// getter --- setter
	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Date getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

}
