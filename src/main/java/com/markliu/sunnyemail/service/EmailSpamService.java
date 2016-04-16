package com.markliu.sunnyemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markliu.sunnyemail.dao.EmailSpamDao;
import com.markliu.sunnyemail.entities.EmailSpam;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 5:32:27 PM
 */
@Service
public class EmailSpamService {

	@Autowired
	private EmailSpamDao emailSpamDao;

	public boolean saveEmailSpam(EmailSpam emailSpam) {
		return emailSpamDao.saveEmailSpam(emailSpam);
	}

	public boolean deleteEmailSpamById(Integer id) {
		return emailSpamDao.deleteEmailSpamById(id);
	}

	public boolean updateEmailSpam(EmailSpam emailSpam) {
		return emailSpamDao.updateEmailSpam(emailSpam);
	}

	public int getTotalEmailSpamCount() {
		return emailSpamDao.getTotalEmailSpamCount();
	}

	public EmailSpam getEmailSpamById(Integer id) {
		return emailSpamDao.getEmailSpamById(id);
	}

}
