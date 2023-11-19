package com.appdev.techno.ie.nurturehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;

@Repository
public interface CaregiverRepository extends JpaRepository<CaregiverEntity, Integer>{
	CaregiverEntity findByUsername(String username);
}
 