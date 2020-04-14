
package com.example.IFANOW.service.impl;


import com.example.IFANOW.model.EmailTemplate;
import com.example.IFANOW.repository.db.EmailTemplateRepository;
import com.example.IFANOW.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("emailTemplateService")
@Transactional
public class EmailTemplateServiceImpl implements EmailTemplateService {


    @Autowired
    private EmailTemplateRepository emailTemplateRepository;

	
	@Override
	public List<EmailTemplate> findAllEmailTemplates() {
		
		return emailTemplateRepository.findAll();
	}

	@Override
	public List<EmailTemplate> findEmailTemplate(String name) {
		
		return emailTemplateRepository.findEmailTemplate(name);
	}

	@Override
	public Optional<EmailTemplate> findById(int id) throws Exception {

		return emailTemplateRepository.findById(id);
	}

	@Override
	public EmailTemplate saveEmailTemplate(EmailTemplate emailTemplate) throws Exception {

		return emailTemplateRepository.save(emailTemplate);
	}

	@Override
	public void updateEmailTemplate(EmailTemplate emailTemplate) throws Exception {

        emailTemplateRepository.save(emailTemplate);
	}
}

