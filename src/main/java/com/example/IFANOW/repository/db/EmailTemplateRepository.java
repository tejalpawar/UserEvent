package com.example.IFANOW.repository.db;

import com.example.IFANOW.model.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailTemplateRepository  extends JpaRepository<EmailTemplate, Integer> {

    Optional<EmailTemplate> findById(int id);

    @Query("select e from EmailTemplate e where e.name like %?1")
    List<EmailTemplate> findEmailTemplate(String name);

}
