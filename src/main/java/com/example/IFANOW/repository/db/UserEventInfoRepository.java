package com.example.IFANOW.repository.db;


import com.example.IFANOW.model.UserEventInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventInfoRepository extends JpaRepository<UserEventInfo, Integer>  {
}
