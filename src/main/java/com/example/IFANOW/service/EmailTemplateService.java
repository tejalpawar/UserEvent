package com.example.IFANOW.service;

import com.example.IFANOW.model.EmailTemplate;

import java.util.List;
import java.util.Optional;


public interface EmailTemplateService {

	List<EmailTemplate> findAllEmailTemplates();
	List<EmailTemplate> findEmailTemplate(String name);
	Optional<EmailTemplate> findById(int id) throws Exception;

	EmailTemplate saveEmailTemplate(EmailTemplate emailTemplate) throws Exception;

	void updateEmailTemplate(EmailTemplate emailTemplate) throws Exception;
}