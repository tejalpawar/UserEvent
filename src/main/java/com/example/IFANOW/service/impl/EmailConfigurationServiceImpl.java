
package com.example.IFANOW.service.impl;


import com.example.IFANOW.model.EmailConfiguration;
import com.example.IFANOW.repository.db.EmailConfigurationRepository;
import com.example.IFANOW.service.EmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("emailConfigurationService")
@Transactional
public class EmailConfigurationServiceImpl implements EmailConfigurationService {

	@Autowired
	private EmailConfigurationRepository emailConfigurationRepository;

	@Override
	public List<EmailConfiguration> findAllEmailConfigurations() {

		return emailConfigurationRepository.findAll();
	}


	@Override
	public EmailConfiguration saveEmailConfiguration(EmailConfiguration empConfig) throws Exception {
		
		return emailConfigurationRepository.save(empConfig);
	}

	@Override
	public void updateEmailConfiguration(EmailConfiguration empConfig) throws Exception {

        emailConfigurationRepository.save(empConfig);
	}

	@Override
	public EmailConfiguration findById(int id) {

		return emailConfigurationRepository.findById(id);
	}

}

