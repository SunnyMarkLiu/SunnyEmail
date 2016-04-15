package com.markliu.sunnyemail.entities;

/**
 * �ѷ����ʼ�
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 1:42:37 PM
 */
public class EmailSented {
	private Integer id;
	private EmailInfo email;

	public EmailSented() {
	}

	public EmailSented(Integer id, EmailInfo email) {
		super();
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
