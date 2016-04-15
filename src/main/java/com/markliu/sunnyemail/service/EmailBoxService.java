package com.markliu.sunnyemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markliu.sunnyemail.dao.EmailBoxDao;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 5:36:40 PM
 */
@Service
public class EmailBoxService<T> {

	@Autowired
	private EmailBoxDao<T> emailBoxDao;

	public boolean saveToEmailBox(T object) {
		return emailBoxDao.saveToEmailBox(object);
	}

	public boolean deleteFromEmailBox(T box, Integer id) {
		return emailBoxDao.deleteFromEmailBox(box, id);
	}

	public boolean updateEmailBox(T emailInfo) {
		return emailBoxDao.updateEmailBox(emailInfo);
	}

	public int getTotalEmailBox() {
		return emailBoxDao.getTotalEmailBox();
	}

	public T getEmailBoxId(Integer id) {
		return emailBoxDao.getEmailBoxId(id);
	}

}
