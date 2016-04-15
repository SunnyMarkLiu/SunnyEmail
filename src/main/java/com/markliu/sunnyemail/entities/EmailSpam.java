package com.markliu.sunnyemail.entities;

/**
 * ���������ʼ�
 * 
 * @auther SunnyMarkLiu
 * @time Apr 15, 2016 1:41:37 PM
 */
public class EmailSpam {
	private Integer id;
	private EmailInfo email;

	public EmailSpam() {
	}

	public EmailSpam(Integer id, EmailInfo email) {
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
