package com.shopping.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.Product;

/**
 * @author ������ ��Ʒ����ӿ���
 *
 */
public interface ProductDao {
	// ��ȡ���в�Ʒ,����ģ����ѯ�Լ���ҳ
	public List<Product> getProducts(@SuppressWarnings("rawtypes") @Param("page") Page page,
			@Param("productId") Integer productId,
			@Param("productName") String productName,
			@Param("firstDate") Date firstDate,
			@Param("lastDate") Date lastDate,
			@Param("categoryThreeId") Integer CategoryId);

	public Integer add(Product product); // ���

	public Integer update(Product product); // �޸�

	public Integer delete(Integer productId); // ɾ��
	// ��ȡ��������,���ڷ�ҳ��ʾ

	public Integer getCount(@SuppressWarnings("rawtypes") @Param("page") Page page,
			@Param("product") Integer productId,
			@Param("productName") String productName,
			@Param("firstDate") Date firstDate,
			@Param("lastDate") Date lastDate,
			@Param("categoryThreeId") Integer CategoryId);
}
