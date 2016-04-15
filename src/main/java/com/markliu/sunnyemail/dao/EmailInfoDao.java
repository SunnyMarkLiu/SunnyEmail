package com.markliu.sunnyemail.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.markliu.sunnyemail.entities.EmailInfo;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 4:28:30 PM
 */
@Repository
public class EmailInfoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	/**
	 * 保存邮件
	 * @param emailInfo
	 */
	public boolean saveEmailInfo(EmailInfo emailInfo) {
		try {
			getSession().save(emailInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 根据 id 删除邮件
	 * @param id
	 * @return
	 */
	public boolean deleteEmailInfoById(Integer id) {
		String hql = "DELETE FROM EmailInfo e WHERE e.id = ?";
		try {
			getSession().createQuery(hql).setInteger(0, id).executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 更新邮件
	 * @param emailInfo
	 * @return
	 */
	public boolean updateEmailInfo(EmailInfo emailInfo) {
		try {
			getSession().update(emailInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 获取邮件的总数目
	 * @return
	 */
	public int getTotalEmailCount() {
		String hql = "SELECT count(e.id) FROM EmailInfo e";
		try {
			Integer count = (Integer) getSession().createQuery(hql).uniqueResult();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 根据 id 号获取邮件
	 * @param id
	 * @return
	 */
	public EmailInfo getEmailInfoById(Integer id) {
		String hql = "SELECT FROM EmailInfo e WHERE e.id = ?";
		try {
			EmailInfo emailInfo = (EmailInfo) getSession().createQuery(hql)
					.setInteger(0, id).uniqueResult();
			return emailInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
