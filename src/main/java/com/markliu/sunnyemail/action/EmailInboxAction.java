package com.markliu.sunnyemail.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.markliu.sunnyemail.entities.EmailInbox;
import com.markliu.sunnyemail.service.EmailInboxService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 17, 2016 11:28:16 AM
 */
@Controller
@Scope("prototype")
public class EmailInboxAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = -6020111623490351029L;

	@Autowired
	private EmailInboxService emailInboxService;
	
	private HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	/**
	 * 获取收件箱的所有邮件
	 * @return
	 */
	public String listInbox() {
		
		List<EmailInbox> emailInboxs = emailInboxService.getAllEmailInboxs();
		System.out.println("-----获取收件箱的所有邮件-----" + emailInboxs.size());
		System.out.println(emailInboxs.get(0).getEmail().toString());
		request.setAttribute("emailInboxs", emailInboxs);
		return SUCCESS;
	}

}
