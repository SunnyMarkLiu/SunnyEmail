package com.markliu.sunnyemail.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.markliu.sunnyemail.entities.EmailInbox;
import com.markliu.sunnyemail.entities.EmailInfo;
import com.markliu.sunnyemail.service.EmailInboxService;
import com.markliu.sunnyemail.service.EmailInfoService;
import com.markliu.sunnyemail.util.emailutil.entities.EmailServerInfo;
import com.markliu.sunnyemail.util.emailutil.util.EmailTemplateUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 16, 2016 9:08:43 AM
 */
@Controller("emailInfoAction")
@Scope("prototype")
public class EmailInfoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EmailInfoService emailInfoService;
	private EmailServerInfo emailServerInfo = EmailTemplateUtil.getConfigEmailServerInfo();
	@Autowired
	private EmailInboxService emailInboxService;
	
	public String saveEmailInfo() {
		
		EmailInfo emailInfo = EmailTemplateUtil.getLatestOneEmailInfo(emailServerInfo);
		EmailInbox emailInbox = new EmailInbox(emailInfo);
		emailInfoService.saveEmailInfo(emailInfo);
		emailInboxService.saveEmailInbox(emailInbox);
		return SUCCESS;
	}
	
	public String deleteEmailInfo() {
		
		EmailInfo emailInfo = EmailTemplateUtil.getLatestOneEmailInfo(emailServerInfo);
		emailInfoService.saveEmailInfo(emailInfo);
		return "saveEmailInfo";
	}
	
	private String email_id;
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	private InputStream readedInputStream;
	
	public InputStream getReadedInputStream() {
		return readedInputStream;
	}
	
	public String setEmailReaded() throws Exception {
		System.out.println("点击的email：" + email_id);
		emailInfoService.setEmailReaded(email_id);
		readedInputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		return "setEmailReaded";
	}
	
}
