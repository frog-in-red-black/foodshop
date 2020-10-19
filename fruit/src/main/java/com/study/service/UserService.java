package com.study.service;

import com.study.entity.User;

public interface UserService {

	public User userLogin(User user);

	public int userReg(User user);

}
