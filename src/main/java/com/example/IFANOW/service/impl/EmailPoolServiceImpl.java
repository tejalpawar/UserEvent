package com.example.IFANOW.service.impl;


import com.example.IFANOW.model.EmailPool;
import com.example.IFANOW.repository.db.EmailPoolRepository;
import com.example.IFANOW.service.EmailPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("emailPoolService")
@Transactional
public class EmailPoolServiceImpl implements EmailPoolService {

    @Autowired
    private EmailPoolRepository emailRepository;

    @Override
    public EmailPool findById(Integer id) {
        Optional<EmailPool> emailPool=emailRepository.findById(id);
        return emailPool.get();
    }

    @Override
    public EmailPool save(EmailPool emailPool) {
       return emailRepository.save(emailPool);
    }


}
