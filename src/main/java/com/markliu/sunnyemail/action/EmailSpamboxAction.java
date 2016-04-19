package com.markliu.sunnyemail.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.markliu.sunnyemail.entities.EmailSpam;
import com.markliu.sunnyemail.service.EmailSpamService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 19, 2016 4:10:34 PM
 */
@Controller
@Scope("prototype")
public class EmailSpamboxAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 484853634717069935L;

	@Autowired
	private EmailSpamService emailSpamService;
	
	private HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String listSpambox() {
		List<EmailSpam> emailSpams = emailSpamService.getAllSpamboxs();
		request.setAttribute("emailSpams", emailSpams);
		return "listSpambox";
	}
	
	private String emailSpam_id;
	public void setEmailSpam_id(String emailSpam_id) {
		this.emailSpam_id = emailSpam_id;
	}
	
	private InputStream deleteSpamEmailInputStream;
	
	public InputStream getDeleteSpamEmailInputStream() {
		return deleteSpamEmailInputStream;
	}
	
	public String deleteSpamEmail() throws Exception {
		emailSpamService.deleteEmailSpamById(Integer.parseInt(emailSpam_id));
		deleteSpamEmailInputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		return "deleteSpamEmail";
	}
	
	public String clearAll() {
		emailSpamService.deleteAllEmailSpams();
		return "clearAll";
	}
}
