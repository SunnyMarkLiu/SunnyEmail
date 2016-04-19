package com.markliu.sunnyemail.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.markliu.sunnyemail.entities.EmailDeleted;
import com.markliu.sunnyemail.entities.EmailInfo;
import com.markliu.sunnyemail.entities.EmailSented;
import com.markliu.sunnyemail.service.EmailDeletedService;
import com.markliu.sunnyemail.service.EmailInfoService;
import com.markliu.sunnyemail.service.EmailSentedService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 19, 2016 9:31:47 AM
 */
@Controller
@Scope("prototype")
public class EmailSentedboxAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = 8043827534925554000L;

	@Autowired
	private EmailSentedService emailSentedService;
	@Autowired
	private EmailDeletedService emailDeletedService;
	@Autowired
	private EmailInfoService emailInfoService;
	
	private HttpServletRequest request;
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String listSentedbox() {
		
		List<EmailSented> emailSentedbox =  emailSentedService.getAllEmailSentedbox();
		request.setAttribute("emailSentedbox", emailSentedbox);
		return "listSentedbox";
	}
	
	private InputStream deleteEmailInputStream;
	public InputStream getDeleteEmailInputStream() {
		return deleteEmailInputStream;
	}
	
	private String emailSented_id;
	public void setEmailSented_id(String emailSented_id) {
		this.emailSented_id = emailSented_id;
	}
	
	private String email_id;
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public String deleteEmailSented() throws Exception {
		emailSentedService.deleteEmailSentedById(Integer.parseInt(emailSented_id)); // 此处是args 设置传入EmailInbox的id
		EmailInfo emailInfo = emailInfoService.getEmailInfoById(Integer.parseInt(email_id));
		emailDeletedService.saveEmailDeleted(new EmailDeleted(emailInfo));
		deleteEmailInputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		return "deleteEmailSented";
	}
}
