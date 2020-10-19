package com.study.dao;

import com.study.entity.User;

public interface UserDao {

	public User userLogin(User user) ;

	public int userReg(User user);

}
