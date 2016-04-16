package com.markliu.sunnyemail.entities;

/**
 * �ռ���
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 1:40:34 PM
 */
public class EmailInbox {
	private Integer id;
	private EmailInfo email;

	public EmailInbox() {
	}

	public EmailInbox(EmailInfo email) {
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
