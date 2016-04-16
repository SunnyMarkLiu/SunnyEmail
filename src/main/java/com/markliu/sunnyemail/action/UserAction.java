package com.markliu.sunnyemail.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.markliu.sunnyemail.entities.User;
import com.markliu.sunnyemail.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 16, 2016 2:11:57 PM
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 4394064723061149474L;

	@Autowired
	private UserService userService;
	
	private String emailAddress;
	private String password;
	private HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		User user = userService.getUser(emailAddress, password);
		if (user != null) {
			// 将 user 信息放进 application 请求域
			request.getSession().setAttribute("user", user);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
