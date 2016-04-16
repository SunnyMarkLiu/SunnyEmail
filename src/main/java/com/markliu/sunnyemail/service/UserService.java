package com.markliu.sunnyemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markliu.sunnyemail.dao.UserDao;
import com.markliu.sunnyemail.entities.User;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 16, 2016 2:24:50 PM
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUser(String emailAddress, String password) {
		return userDao.getUser(emailAddress, password);
	}
	
}
