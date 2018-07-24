package com.shopping.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.UserDao;
import com.shopping.entity.User;
import com.shopping.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao uDao;

	@Override
	public User commonUserLogin(String username, String pwd) {
		return uDao.commonUserLogin(username, pwd);
	}

	@Override
	public Integer adminUserAdd(User user) {
		return uDao.adminUserAdd(user);
	}

	@Override
	public User adminUserLogin(String UserName, String pwd) {
		return uDao.adminUserLogin(UserName, pwd);
	}
}
