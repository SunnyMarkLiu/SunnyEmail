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
import com.markliu.sunnyemail.entities.EmailInbox;
import com.markliu.sunnyemail.entities.EmailInfo;
import com.markliu.sunnyemail.service.EmailDeletedService;
import com.markliu.sunnyemail.service.EmailInboxService;
import com.markliu.sunnyemail.service.EmailInfoService;
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
	private EmailInfoService emailInfoService;
	@Autowired
	private EmailInboxService emailInboxService;
	@Autowired
	private EmailDeletedService emailDeletedService;
	
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
		request.setAttribute("emailInboxs", emailInboxs);
		int unReadedCount = emailInboxService.getAllUnReadedCount();
		request.setAttribute("unReadedCount", unReadedCount);
		return SUCCESS;
	}

	private String email_id;
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	private String emailInbox_id;
	public void setEmailInbox_id(String emailInbox_id) {
		this.emailInbox_id = emailInbox_id;
	}
	
	private InputStream deleteEmailInputStream;
	
	public InputStream getDeleteEmailInputStream() {
		return deleteEmailInputStream;
	}
	
	public String deleteEmail() throws Exception {
		emailInboxService.deleteEmailInboxById(Integer.parseInt(emailInbox_id)); // 此处是args 设置传入EmailInbox的id
		EmailInfo emailInfo = emailInfoService.getEmailInfoById(Integer.parseInt(email_id));
		emailDeletedService.saveEmailDeleted(new EmailDeleted(emailInfo));
		deleteEmailInputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		return "deleteEmail";
	}
	
}
