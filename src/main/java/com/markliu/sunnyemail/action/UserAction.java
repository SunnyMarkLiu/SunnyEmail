package com.markliu.sunnyemail.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.markliu.sunnyemail.entities.User;
import com.markliu.sunnyemail.service.EmailDeletedService;
import com.markliu.sunnyemail.service.EmailInboxService;
import com.markliu.sunnyemail.service.EmailSentedService;
import com.markliu.sunnyemail.service.EmailSpamService;
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
public class UserAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 4394064723061149474L;

	@Autowired
	private UserService userService;
	@Autowired
	private EmailInboxService emailInboxService;
	@Autowired
	private EmailSentedService emailSentedService;
	@Autowired
	private EmailDeletedService emailDeletedService;
	@Autowired
	private EmailSpamService emailSpamService;
	
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	private String emailAddress;
	private String password;
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		User user = userService.getUser(emailAddress, password);
		if (user != null) {
			// 将 user 信息放进 session 请求域
			session.put("user", user);
			
			// 放入收件箱、发件箱、回收站等的邮件数目
			
			session.put("totalEmailInboxCount", emailInboxService.getTotalEmailInboxCount());
			session.put("totalEmailSentedCount", emailSentedService.getTotalEmailSentedCount());
			session.put("totalEmailDeletedCount", emailDeletedService.getTotalEmailDeletedCount());
			session.put("totalEmailSpamCount", emailSpamService.getTotalEmailSpamCount());
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	private InputStream inputStream;
	
    public InputStream getInputStream() {
        return inputStream;
    }
    public String ajaxListInfo() throws Exception {
    	
    	int totalEmailInboxCount = emailInboxService.getTotalEmailInboxCount();
    	int totalEmailSentedCount = emailSentedService.getTotalEmailSentedCount();
    	int totalEmailDeletedCount = emailDeletedService.getTotalEmailDeletedCount();
    	int totalEmailSpamCount = emailSpamService.getTotalEmailSpamCount();
    	
    	session.put("totalEmailInboxCount", totalEmailInboxCount);
		session.put("totalEmailSentedCount", totalEmailSentedCount);
		session.put("totalEmailDeletedCount", totalEmailDeletedCount);
		session.put("totalEmailSpamCount", totalEmailSpamCount);

		String json = "{\"emailInboxCount\":"+totalEmailInboxCount+",\"emailSentedCount\":"+totalEmailSentedCount+
    			",\"emailDeletedCount\":"+totalEmailDeletedCount+",\"emailSpamCount\":"+totalEmailSpamCount+"}";
        
    	inputStream = new ByteArrayInputStream(json.getBytes("UTF-8"));
        return "ajaxListInfo";
    }
}
