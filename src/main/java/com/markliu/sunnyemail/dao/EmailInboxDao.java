package com.markliu.sunnyemail.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.markliu.sunnyemail.entities.EmailInbox;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 4:28:30 PM
 */
@Repository
public class EmailInboxDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public boolean saveEmailInbox(EmailInbox emailInbox) {
		try {
			getSession().save(emailInbox);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteEmailInboxById(Integer id) {
		String hql = "DELETE EmailInbox e WHERE e.id = ?";
		try {
			getSession().createQuery(hql).setInteger(0, id).executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateEmailInbox(EmailInbox emailInbox) {
		try {
			getSession().update(emailInbox);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getTotalEmailInboxCount() {
		String hql = "SELECT count(e.id) FROM EmailInbox e";
		try {
			Long count = (Long) getSession().createQuery(hql).uniqueResult();
			return count.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmailInbox> getAllUnReadedEmailInboxs() {
		String hql = "FROM EmailInbox e WHERE e.email.isReaded = false";
		try {
			List<EmailInbox> emailInboxs = getSession().createQuery(hql).list();
			return emailInboxs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<EmailInbox> getAllEmailInboxs() {
//		String hql = "FROM EmailInbox e ORDER BY e.email.isReaded ASC,e.email.priority DESC";
		try {
			String hql = "FROM EmailInbox e WHERE e.email.isReaded = false ORDER BY e.email.priority DESC";
			List<EmailInbox> emailInboxs1 = getSession().createQuery(hql).list();
			hql = "FROM EmailInbox e WHERE e.email.isReaded = true ORDER BY e.email.sentDate DESC";
			List<EmailInbox> emailInboxs2 = getSession().createQuery(hql).list();
			emailInboxs1.addAll(emailInboxs2);
			return emailInboxs1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public EmailInbox getEmailInboxById(Integer id) {
		String hql = "SELECT FROM EmailInbox e WHERE e.id = ?";
		try {
			EmailInbox emailInbox = (EmailInbox) getSession().createQuery(hql)
					.setInteger(0, id).uniqueResult();
			return emailInbox;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getAllUnReadedCount() {
		String hql = "SELECT count(e.id) FROM EmailInbox e WHERE e.email.isReaded = false";
		try {
			Long count = (Long) getSession().createQuery(hql).uniqueResult();
			return count.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
