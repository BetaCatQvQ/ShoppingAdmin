package com.shopping.entity;

import java.util.List;

/**
 * 
 * @author ������ 
 * ҳ����,���ڷ�ҳ��ѯ
 * @param <T>
 */
public class Page<T> {
	private Integer pageNo = 1;	//��ʾ��ǰ�ڼ�ҳ
	@SuppressWarnings("unused")
	private Integer pageCount;	//��ʾ��ҳ��
	private Integer pageSize;	//ÿҳ��ʾ������
	private Integer rowCount;	//�ܼ�¼��
	private List<T> data;	//װ������
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
	
	//��ȡҳ���һ����¼���±�,û��˽������,����ֻҪ��get�����Ϳ��Ի��
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
