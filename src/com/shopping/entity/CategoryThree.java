package com.shopping.entity;

public class CategoryThree {
	/**
	 * �����˵����
	 */
	private Integer categoryThreeId;
	/**
	 * �����˵�
	 */
	private CategoryTwo categoryTwo;
	/**
	 * �����˵�����
	 */
	private String categoryThreeName;

	// getter --- setter
	public Integer getCategoryThreeId() {
		return categoryThreeId;
	}

	public void setCategoryThreeId(Integer categoryThreeId) {
		this.categoryThreeId = categoryThreeId;
	}

	public CategoryTwo getCategoryTwo() {
		return categoryTwo;
	}

	public void setCategoryTwo(CategoryTwo categoryTwo) {
		this.categoryTwo = categoryTwo;
	}

	public String getCategoryThreeName() {
		return categoryThreeName;
	}

	public void setCategoryThreeName(String categoryThreeName) {
		this.categoryThreeName = categoryThreeName;
	}

}
