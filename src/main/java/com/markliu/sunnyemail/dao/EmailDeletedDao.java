package com.markliu.sunnyemail.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.markliu.sunnyemail.entities.EmailDeleted;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 4:28:30 PM
 */
@Repository
public class EmailDeletedDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public boolean saveEmailDeleted(EmailDeleted emailDeleted) {
		try {
			getSession().save(emailDeleted);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEmailDeletedById(Integer id) {
		String hql = "DELETE FROM EmailDeleted e WHERE e.id = ?";
		try {
			getSession().createQuery(hql).setInteger(0, id).executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateEmailDeleted(EmailDeleted emailDeleted) {
		try {
			getSession().update(emailDeleted);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getTotalEmailDeletedCount() {
		String hql = "SELECT count(e.id) FROM EmailDeleted e";
		try {
			Integer count = (Integer) getSession().createQuery(hql).uniqueResult();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public EmailDeleted getEmailDeletedById(Integer id) {
		String hql = "SELECT FROM EmailDeleted e WHERE e.id = ?";
		try {
			EmailDeleted emailDeleted = (EmailDeleted) getSession().createQuery(hql)
					.setInteger(0, id).uniqueResult();
			return emailDeleted;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
