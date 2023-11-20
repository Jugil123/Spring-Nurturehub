package com.appdev.techno.ie.nurturehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.techno.ie.nurturehub.Entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
	
}
