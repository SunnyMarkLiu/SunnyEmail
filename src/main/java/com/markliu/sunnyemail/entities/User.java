package com.markliu.sunnyemail.entities;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 16, 2016 2:15:08 PM
 */
public class User {

	private Integer id;
	private String emailAddress;
	private String password;

	public User(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
