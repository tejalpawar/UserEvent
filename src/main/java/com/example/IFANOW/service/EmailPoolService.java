package com.example.IFANOW.service;

import com.example.IFANOW.model.EmailPool;

import java.util.Optional;

public interface EmailPoolService {

	EmailPool findById(Integer id);

	EmailPool save(EmailPool emailPool);

/*	List<EmailPool> findAllEmailPool();

	Integer saveEmailPool(EmailPool emailPool) throws Exception;

	List<EmailPool> findEmailPool(EmailPool emailPool);

	void updateEmailPool(EmailPool emailPool);*/
}