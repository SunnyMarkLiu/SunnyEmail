package com.markliu.sunnyemail.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.markliu.sunnyemail.entities.EmailSpam;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 4:28:30 PM
 */
@Repository
public class EmailSpamDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public boolean saveEmailSpam(EmailSpam emailSpam) {
		try {
			getSession().save(emailSpam);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEmailSpamById(Integer id) {
		String hql = "DELETE FROM EmailSpam e WHERE e.id = ?";
		try {
			getSession().createQuery(hql).setInteger(0, id).executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateEmailSpam(EmailSpam emailSpam) {
		try {
			getSession().update(emailSpam);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getTotalEmailSpamCount() {
		String hql = "SELECT count(e.id) FROM EmailSpam e";
		try {
			Long count = (Long) getSession().createQuery(hql).uniqueResult();
			return count.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public EmailSpam getEmailSpamById(Integer id) {
		String hql = "SELECT FROM EmailSpam e WHERE e.id = ?";
		try {
			EmailSpam emailSpam = (EmailSpam) getSession().createQuery(hql)
					.setInteger(0, id).uniqueResult();
			return emailSpam;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
