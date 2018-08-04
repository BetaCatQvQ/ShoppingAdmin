package com.shopping.entity;

import java.util.List;

/**
 * 
 * @author 焦明扬 
 * 页面类,用于分页查询
 * @param <T>
 */
public class Page<T> {
	private Integer pageNo = 1;	//表示当前第几页
	@SuppressWarnings("unused")
	private Integer pageCount;	//表示总页数
	private Integer pageSize;	//每页显示的行数
	private Integer rowCount;	//总记录数
	private List<T> data;	//装载数据
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageCount() {
		if (rowCount==1) {
			pageCount = 1;
			return pageCount;
		}else {
			return (rowCount - 1) / pageSize + 1;
		}
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public Page() {
		super();
	}
	
	//获取页面第一条记录的下标,没有私有属性,但是只要有get方法就可以获得
	public Integer getFirstIndex(){
		return (pageNo-1) * pageSize;
	}
	
/*	public Page(Integer pageCount, Integer pageSize, Integer rowCount,
			List<T> data) {
		super();
		this.pageCount = pageCount;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.data = data;
	}
	public Page(Integer pageNo, Integer pageCount, Integer pageSize,
			Integer rowCount, List<T> data) {
		super();
		this.pageNo = pageNo;
		this.pageCount = pageCount;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.data = data;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageCount=" + pageCount
				+ ", pageSize=" + pageSize + ", rowCount=" + rowCount
				+ ", data=" + data + "]";
	}*/
}
