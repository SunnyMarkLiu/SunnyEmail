package com.markliu.sunnyemail.entities;

import java.util.Date;

/**
 * 读取邮件的POJO
 * 
 * @auther SunnyMarkLiu
 * @time Apr 12, 2016 10:20:32 PM
 */
public class EmailInfo {

	private Integer id;
	/**
	 * 接收方的邮箱地址,注意有多个，操作时需要解析
	 */
	private String toAddress;

	/**
	 * 邮件主题
	 */
	private String subject;

	/**
	 * 邮件内容
	 */
	private String content;

	/**
	 * 待上传附件的路径及名称�?�或下载附件的地�?及名�? ,注意有多个，操作时需要解析
	 */
	private String attachmentFiles;

	/**
	 * 发�?�方的地�?
	 */
	private String fromAddress;

	/**
	 * 发�?�的时间
	 */
	private Date sentDate;

	/**
	 * 是否�?要邮件回�?
	 */
	private boolean needReply;

	/**
	 * 是否已读
	 */
	private boolean isReaded;

	/**
	 * 是否包含附件
	 */
	private boolean containsAttachments = false;

	/**
	 * 抄�?? ,注意有多个，操作时需要解析
	 */
	private String carbonCopy;

	/**
	 * 暗抄�? ,注意有多个，操作时需要解析
	 */
	private String darkCopy;

	/**
	 * 此邮件的Message-ID
	 */
	private String messageID;
	
	/**
	 * <b>新邮件</b>需要被阅读的优先级，该优先级别由机器学习算法得到
	 */
	private float priority;

	public EmailInfo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public boolean isNeedReply() {
		return needReply;
	}

	public void setNeedReply(boolean needReply) {
		this.needReply = needReply;
	}

	public boolean isReaded() {
		return isReaded;
	}

	public void setReaded(boolean isReaded) {
		this.isReaded = isReaded;
	}

	public boolean isContainsAttachments() {
		return containsAttachments;
	}

	public void setContainsAttachments(boolean containsAttachments) {
		this.containsAttachments = containsAttachments;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getAttachmentFiles() {
		return attachmentFiles;
	}

	public void setAttachmentFiles(String attachmentFiles) {
		this.attachmentFiles = attachmentFiles;
	}

	public String getCarbonCopy() {
		return carbonCopy;
	}

	public void setCarbonCopy(String carbonCopy) {
		this.carbonCopy = carbonCopy;
	}

	public String getDarkCopy() {
		return darkCopy;
	}

	public void setDarkCopy(String darkCopy) {
		this.darkCopy = darkCopy;
	}

	public float getPriority() {
		return priority;
	}

	public void setPriority(float priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "EmailInfo [id=" + id + ", toAddress=" + toAddress
				+ ", subject=" + subject + ", content=" + content
				+ ", attachmentFiles=" + attachmentFiles + ", fromAddress="
				+ fromAddress + ", sentDate=" + sentDate + ", needReply="
				+ needReply + ", isReaded=" + isReaded
				+ ", containsAttachments=" + containsAttachments
				+ ", carbonCopy=" + carbonCopy + ", darkCopy=" + darkCopy
				+ ", messageID=" + messageID + ", priority=" + priority + "]";
	}

}
