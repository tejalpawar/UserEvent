package com.example.IFANOW.repository.db;

import com.example.IFANOW.model.EmailPool;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailPoolRepository extends JpaRepository<EmailPool, Integer> {


    Optional<EmailPool> findById(Integer id);
}
