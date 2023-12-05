package com.appdev.techno.ie.nurturehub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.techno.ie.nurturehub.Entity.ServiceHistoryEntity;

public interface ServiceHistoryRepository extends JpaRepository<ServiceHistoryEntity, Integer>{
	List<ServiceHistoryEntity> findByRecipient(String recipient);
    
}
