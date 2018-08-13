package com.shopping.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Page;
import com.shopping.entity.Product;

/**
 * 
 * @author ������ ��Ʒ�����ҵ���߼��ӿ�
 *
 */
public interface ProductService {
	// ��ȡ���в�Ʒ,����ģ����ѯ�Լ���ҳ
	public List<Map> getProducts(@SuppressWarnings("rawtypes") Page page,
	/* ("productId") BigInteger productId, */
	String productName, String firstDate, String lastDate, Integer CategoryId,
			String categoryType);

	public Integer add(Product product); // ���

	public Integer update(Product product); // �޸�

	public Integer delete(BigInteger productId); // ɾ��
	// ��ȡ��������,���ڷ�ҳ��ʾ

	public Integer getCount(
			@SuppressWarnings("rawtypes")Page page,
			String productName,
			String firstDate,
			String lastDate,
			Integer CategoryId,
			String categoryType);

	public Product getProductByProductId(BigInteger productId);
}
