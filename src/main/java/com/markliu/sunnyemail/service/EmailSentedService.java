package com.markliu.sunnyemail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markliu.sunnyemail.dao.EmailSentedDao;
import com.markliu.sunnyemail.entities.EmailSented;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 5:32:27 PM
 */
@Service
public class EmailSentedService {

	@Autowired
	private EmailSentedDao emailSentedDao;

	public boolean saveEmailSented(EmailSented emailSented) {
		return emailSentedDao.saveEmailSented(emailSented);
	}

	public boolean deleteEmailSentedById(Integer id) {
		return emailSentedDao.deleteEmailSentedById(id);
	}

	public boolean updateEmailSented(EmailSented emailSented) {
		return emailSentedDao.updateEmailSented(emailSented);
	}

	public int getTotalEmailSentedCount() {
		return emailSentedDao.getTotalEmailSentedCount();
	}

	public EmailSented getEmailSentedById(Integer id) {
		return emailSentedDao.getEmailSentedById(id);
	}

	public List<EmailSented> getAllEmailSentedbox() {
		return emailSentedDao.getAllEmailSentedbox();
	}
}
