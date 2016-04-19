package com.markliu.sunnyemail.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.markliu.sunnyemail.entities.EmailInfo;
import com.markliu.sunnyemail.entities.EmailSented;
import com.markliu.sunnyemail.entities.User;
import com.markliu.sunnyemail.service.EmailInfoService;
import com.markliu.sunnyemail.service.EmailSentedService;
import com.markliu.sunnyemail.util.emailutil.entities.EmailServerInfo;
import com.markliu.sunnyemail.util.emailutil.util.EmailTemplateUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 
 * @auther SunnyMarkLiu
 * @time Apr 19, 2016 11:38:56 AM
 */
@Controller
@Scope("prototype")
public class SendEmailAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6055343694870179535L;
	
    private File[] attachments;
    private String[] attachmentsContentType;
    private String[] attachmentsFileName;
    
	private String subject;
	private String toAddress;
	private String content;
	
	public String[] getAttachmentsContentType() {
		return attachmentsContentType;
	}

	public void setAttachmentsContentType(String[] attachmentsContentType) {
		this.attachmentsContentType = attachmentsContentType;
	}

	public File[] getAttachments() {
		return attachments;
	}

	public void setAttachments(File[] attachments) {
		this.attachments = attachments;
	}

	public String[] getAttachmentsFileName() {
		return attachmentsFileName;
	}

	public void setAttachmentsFileName(String[] attachmentsFileName) {
		this.attachmentsFileName = attachmentsFileName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Autowired
	private EmailInfoService emailInfoService;
	@Autowired
	private EmailSentedService emailSentedService;
	
	public String sendEmail() throws IOException {
        StringBuilder attachmentFiles = new StringBuilder();
        EmailInfo email = new EmailInfo();
        if (attachments != null && attachments.length > 0) {
        	email.setContainsAttachments(true);
            for(int i = 0; i < attachments.length; i++) {
                FileUtils.copyFile(attachments[i], new File("E:\\email_attachments\\upload\\", attachmentsFileName[i]));
                System.out.println("附件保存的路径：" + attachmentsFileName[i]);
                attachmentFiles.append("E:\\email_attachments\\upload\\" + attachmentsFileName[i] + ";");
            }
        }
        email.setSentDate(new Date());
        email.setSubject(subject);
        email.setContent(content);
        email.setToAddress(toAddress);
        email.setFromAddress(((User)session.get("user")).getEmailAddress());
        email.setAttachmentFiles(attachmentFiles.toString());
        email.setNeedReply(false);
        email.setReaded(false);
        EmailServerInfo emailServerInfo = EmailTemplateUtil.getConfigEmailServerInfo();
        EmailTemplateUtil.sendEmail(emailServerInfo, email);
        
        // 保存邮件
        emailInfoService.saveEmailInfo(email);
        emailSentedService.saveEmailSented(new EmailSented(email));
        return SUCCESS;
    }

}
