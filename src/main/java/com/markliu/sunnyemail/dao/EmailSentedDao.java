package com.markliu.sunnyemail.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.markliu.sunnyemail.entities.EmailSented;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 4:28:30 PM
 */
@Repository
public class EmailSentedDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public boolean saveEmailSented(EmailSented emailSented) {
		try {
			getSession().save(emailSented);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEmailSentedById(Integer id) {
		String hql = "DELETE FROM EmailSented e WHERE e.id = ?";
		try {
			getSession().createQuery(hql).setInteger(0, id).executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateEmailSented(EmailSented emailSented) {
		try {
			getSession().update(emailSented);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getTotalEmailSentedCount() {
		String hql = "SELECT count(e.id) FROM EmailSented e";
		try {
			Integer count = (Integer) getSession().createQuery(hql).uniqueResult();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public EmailSented getEmailSentedById(Integer id) {
		String hql = "SELECT FROM EmailSented e WHERE e.id = ?";
		try {
			EmailSented emailSented = (EmailSented) getSession().createQuery(hql)
					.setInteger(0, id).uniqueResult();
			return emailSented;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
