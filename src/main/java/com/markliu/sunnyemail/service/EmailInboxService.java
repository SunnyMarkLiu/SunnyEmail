package com.markliu.sunnyemail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markliu.sunnyemail.dao.EmailInboxDao;
import com.markliu.sunnyemail.entities.EmailInbox;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 5:32:27 PM
 */
@Service
public class EmailInboxService {

	@Autowired
	private EmailInboxDao emailInboxDao;
	
	public boolean saveEmailInbox(EmailInbox emailInbox) {
		return emailInboxDao.saveEmailInbox(emailInbox);
	}
	
	public boolean deleteEmailInboxById(Integer id) {
		return emailInboxDao.deleteEmailInboxById(id);
	}
	
	public boolean updateEmailInbox(EmailInbox emailInbox) {
		return emailInboxDao.updateEmailInbox(emailInbox);
	}
	
	public int getTotalEmailInboxCount() {
		return emailInboxDao.getTotalEmailInboxCount();
	}
	
	public List<EmailInbox> getAllUnReadedEmailInboxs() {
		return emailInboxDao.getAllUnReadedEmailInboxs();
	}
	
	public List<EmailInbox> getAllEmailInboxs() {
		return emailInboxDao.getAllEmailInboxs();
	}
	
	public EmailInbox getEmailInboxById(Integer id) {
		return emailInboxDao.getEmailInboxById(id);
	}

	public int getAllUnReadedCount() {
		return emailInboxDao.getAllUnReadedCount();
	}
	
}
