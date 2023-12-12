package com.appdev.techno.ie.nurturehub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev.techno.ie.nurturehub.Entity.ServiceHistoryEntity;
@Repository
public interface ServiceHistoryRepository extends JpaRepository<ServiceHistoryEntity, Integer>{
	
	 List<ServiceHistoryEntity> findByCaregiver(String caregiver);
    
}
