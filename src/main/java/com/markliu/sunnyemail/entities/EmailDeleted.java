package com.markliu.sunnyemail.entities;

/**
 * �Ѿ�ɾ�����ʼ�
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 1:41:15 PM
 */
public class EmailDeleted {

	private Integer id;
	private EmailInfo email;

	public EmailDeleted() {
	}

	public EmailDeleted(Integer id, EmailInfo email) {
		this.id = id;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmailInfo getEmail() {
		return email;
	}

	public void setEmail(EmailInfo email) {
		this.email = email;
	}

}
