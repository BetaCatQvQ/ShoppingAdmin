package com.shopping.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.Order;
import com.shopping.entity.Page;

public interface OrderDao {
	public List<Map> listOrder(@Param("orderId") Integer orderId, @Param("orderItemId") Integer orderItemId,
			@Param("startPayTime") Date startPayTime, @Param("endPayTime") Date endPayTime,
			@Param("startConfirmTime") Date startConfirmTime, @Param("endConfirmTime") Date endConfirmTime,
			@Param("page") Page page);

	public Integer getRowsCountByPage(@Param("orderId") Integer orderId, @Param("orderItemId") Integer orderItemId,
			@Param("startPayTime") Date startPayTime, @Param("endPayTime") Date endPayTime,
			@Param("startConfirmTime") Date startConfirmTime, @Param("endConfirmTime") Date endConfirmTime);

	public Order getOrderById(@Param("orderId") Integer orderId);
}
