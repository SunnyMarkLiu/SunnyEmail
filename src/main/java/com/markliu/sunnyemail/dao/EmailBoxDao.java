package com.markliu.sunnyemail.dao;

import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.markliu.sunnyemail.entities.EmailDeleted;
import com.markliu.sunnyemail.entities.EmailInbox;
import com.markliu.sunnyemail.entities.EmailSented;
import com.markliu.sunnyemail.entities.EmailSpam;

/**
 * 收件箱、垃圾箱等 DAO
 * 使用泛型
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 5:03:10 PM
 */
@Repository
public class EmailBoxDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	private String mailBox;
	
	/**
	 * 构造函数，同时获取泛型的类型，决定使用那张数据库表
	 */
	public EmailBoxDao() {
		Type genericType = getClass().getGenericSuperclass();
		if (genericType instanceof EmailDeleted) {
			mailBox = "EmailDeleted";
		} else if (genericType instanceof EmailInbox) {
			mailBox = "EmailInbox";
		} else if (genericType instanceof EmailSented) {
			mailBox = "EmailSented";
		} else if (genericType instanceof EmailSpam) {
			mailBox = "EmailSpam";
		}
	}
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	/**
	 * 保存邮件
	 * @param emailInfo
	 */
	public boolean saveToEmailBox(T object) {
		try {
			getSession().save(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据 id 删除邮件
	 * @param id
	 * @return
	 */
	public boolean deleteFromEmailBox(T box, Integer id) {
		
		String hql = "DELETE FROM " + mailBox + " e WHERE e.id = ?";
		try {
			getSession().createQuery(hql).setInteger(0, id).executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 更新邮件
	 * @param emailInfo
	 * @return
	 */
	public boolean updateEmailBox(T emailInfo) {
		try {
			getSession().update(emailInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 获取邮件的总数目
	 * @return
	 */
	public int getTotalEmailBox() {
		String hql = "SELECT count(e.id) FROM " + mailBox + " e";
		try {
			Integer count = (Integer) getSession().createQuery(hql).uniqueResult();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 根据 id 号获取邮件
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getEmailBoxId(Integer id) {
		String hql = "SELECT FROM " + mailBox + " e WHERE e.id = ?";
		try {
			T emailInfo = (T) getSession().createQuery(hql)
					.setInteger(0, id).uniqueResult();
			return emailInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
