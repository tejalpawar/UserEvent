package com.example.IFANOW.repository.db;

import com.example.IFANOW.model.EmailConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailConfigurationRepository  extends JpaRepository<EmailConfiguration, Integer> {

    EmailConfiguration findById(int id);
}
