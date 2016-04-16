package com.markliu.sunnyemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markliu.sunnyemail.dao.EmailDeletedDao;
import com.markliu.sunnyemail.entities.EmailDeleted;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 5:32:27 PM
 */
@Service
public class EmailDeletedService {

	@Autowired
	private EmailDeletedDao emailDeletedDao;
	
	public boolean saveEmailDeleted(EmailDeleted emailDeleted) {
		return emailDeletedDao.saveEmailDeleted(emailDeleted);
	}
	
	public boolean deleteEmailDeletedById(Integer id) {
		return emailDeletedDao.deleteEmailDeletedById(id);
	}
	
	public boolean updateEmailDeleted(EmailDeleted emailDeleted) {
		return emailDeletedDao.updateEmailDeleted(emailDeleted);
	}
	
	public int getTotalEmailDeletedCount() {
		return emailDeletedDao.getTotalEmailDeletedCount();
	}
	
	public EmailDeleted getEmailDeletedById(Integer id) {
		return emailDeletedDao.getEmailDeletedById(id);
	}
	
}
