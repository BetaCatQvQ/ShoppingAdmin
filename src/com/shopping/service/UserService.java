package com.shopping.service;

import org.apache.ibatis.annotations.Param;

import com.shopping.entity.User;

public interface UserService {
	public User commonUserLogin(String username, String pwd);
	
	public Integer adminUserAdd(User user);
	
	public User adminUserLogin(String UserName,String pwd); 
}
