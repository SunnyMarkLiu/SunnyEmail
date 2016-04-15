package com.markliu.sunnyemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markliu.sunnyemail.dao.EmailInfoDao;
import com.markliu.sunnyemail.entities.EmailInfo;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 5:32:27 PM
 */
@Service
public class EmailInfoService {

	@Autowired
	private EmailInfoDao emailInfoDao;
	
	public boolean saveEmailInfo(EmailInfo emailInfo) {
		return emailInfoDao.saveEmailInfo(emailInfo);
	}
	
	public boolean deleteEmailInfoById(Integer id) {
		return emailInfoDao.deleteEmailInfoById(id);
	}
	
	public boolean updateEmailInfo(EmailInfo emailInfo) {
		return emailInfoDao.updateEmailInfo(emailInfo);
	}
	
	public int getTotalEmailCount() {
		return emailInfoDao.getTotalEmailCount();
	}
	
	public EmailInfo getEmailInfoById(Integer id) {
		return emailInfoDao.getEmailInfoById(id);
	}
	
}
