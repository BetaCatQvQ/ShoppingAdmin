package com.shopping.entity;

public class CategoryTwo {
	/**
	 * �����˵����
	 */
	private Integer categoryTwoId;
	/**
	 * һ���˵�
	 */
	private CategoryOne categoryOne;
	/**
	 * �����˵�����
	 */
	private String categoryTwoName;

	// getter --- setter
	public Integer getCategoryTwoId() {
		return categoryTwoId;
	}

	public void setCategoryTwoId(Integer categoryTwoId) {
		this.categoryTwoId = categoryTwoId;
	}

	public CategoryOne getCategoryOne() {
		return categoryOne;
	}

	public void setCategoryOne(CategoryOne categoryOne) {
		this.categoryOne = categoryOne;
	}

	public String getCategoryTwoName() {
		return categoryTwoName;
	}

	public void setCategoryTwoName(String categoryTwoName) {
		this.categoryTwoName = categoryTwoName;
	}

}
