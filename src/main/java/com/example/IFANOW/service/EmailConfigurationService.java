package com.example.IFANOW.service;



import com.example.IFANOW.model.EmailConfiguration;

import java.util.List;

public interface EmailConfigurationService {

	List<EmailConfiguration> findAllEmailConfigurations();

	EmailConfiguration saveEmailConfiguration(EmailConfiguration empConfig) throws Exception;

	void updateEmailConfiguration(EmailConfiguration empConfig) throws Exception;
	
	EmailConfiguration findById(int id);
}
