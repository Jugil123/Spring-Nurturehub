package com.appdev.techno.ie.nurturehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.appdev.techno.ie.nurturehub.Entity.RecordEntity;

@Repository
public interface RecordRepository extends JpaRepository<RecordEntity, Integer>{
	RecordEntity findByRecipient(String recipient);
}