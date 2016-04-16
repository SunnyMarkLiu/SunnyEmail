package com.markliu.sunnyemail.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.markliu.sunnyemail.entities.User;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 16, 2016 2:18:00 PM
 */
@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	/**
	 * 根据 emailAddress 和 password 获取用户
	 * @param emailAddress
	 * @param password
	 * @return
	 */
	public User getUser(String emailAddress, String password) {
		String hql = "FROM User user WHERE user.emailAddress = ? AND user.password = ?";
		try {
			User user = (User) getSession().createQuery(hql).setString(0, emailAddress)
					.setString(1, password).uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
