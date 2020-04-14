package com.example.IFANOW.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "email_pool")
public class EmailPool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ag_id", nullable = false)
	private String agId;

	@Column(name = "email_from", nullable = false)
	private String emailFrom;

	@Column(name = "email_to", nullable = false)
	private String emailTo;

	@Column(name = "email_cc")
	private String emailCc;

	@Column(name = "email_bcc")
	private String emailBcc;

	@Column(name = "subject", nullable = false)
	private String subject;

	@Column(name = "template_name", nullable = false)
	private String templateName;

	@Column(name = "attachment_location")
	private String attachmentLocation;

	@Column(name = "contents", nullable = false)
	private String contents;

	@Column(name = "send_flag", nullable = false)
	private String sendFlag;
	
	@Column(name = "processing_msg")
	private String processingMsg;	

	@Column(name = "creation_date", nullable = false)
	private Date creationDate;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "modification_date")
	private Date modificationDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgId() {
		return agId;
	}

	public void setAgId(String agId) {
		this.agId = agId;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getEmailCc() {
		return emailCc;
	}

	public void setEmailCc(String emailCc) {
		this.emailCc = emailCc;
	}

	public String getEmailBcc() {
		return emailBcc;
	}

	public void setEmailBcc(String emailBcc) {
		this.emailBcc = emailBcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getAttachmentLocation() {
		return attachmentLocation;
	}

	public void setAttachmentLocation(String attachmentLocation) {
		this.attachmentLocation = attachmentLocation;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}

	public String getProcessingMsg() {
		return processingMsg;
	}

	public void setProcessingMsg(String processingMsg) {
		this.processingMsg = processingMsg;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}