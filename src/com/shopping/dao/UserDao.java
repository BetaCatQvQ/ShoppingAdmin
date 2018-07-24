package com.shopping.dao;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.User;

public interface UserDao {
	public User commonUserLogin(@Param("username") String username, @Param("pwd") String pwd);
	
	public Integer adminUserAdd(@Param("user")User user);
	
	public User adminUserLogin(@Param("username") String UserName,@Param("pwd") String pwd); 
}
