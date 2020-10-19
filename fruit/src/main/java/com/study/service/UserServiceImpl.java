package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.study.dao.UserDao;
import com.study.entity.User;

@Service
public class UserServiceImpl implements  UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		
		return  userDao.userLogin(user);
	}

	@Override
	public int userReg(User user) {
		// TODO Auto-generated method stub
		return  userDao.userReg(user);
	}

}
