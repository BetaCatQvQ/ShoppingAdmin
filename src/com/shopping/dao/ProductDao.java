package com.shopping.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.Product;

/**
 * @author ������ ��Ʒ����ӿ���
 *
 */
public interface ProductDao {
	// ��ȡ���в�Ʒ,����ģ����ѯ�Լ���ҳ
	public List<Map> getProducts(@SuppressWarnings("rawtypes") @Param("page") Page page,
			@Param("productName") String productName,
			@Param("firstDate") String firstDate,
			@Param("lastDate") String lastDate,
			@Param("categoryThreeId") Integer CategoryId);

	public Integer add(Product product); // ���

	public Integer update(Product product); // �޸�

	public Integer delete(BigInteger productId); // ɾ��
	// ��ȡ��������,���ڷ�ҳ��ʾ

	public Integer getCount(@SuppressWarnings("rawtypes") @Param("page") Page page,
			@Param("productName") String productName,
			@Param("firstDate") String firstDate,
			@Param("lastDate") String lastDate,
			@Param("categoryThreeId") Integer CategoryId);
	
	public Product getProductByProductId(BigInteger productId);
}
