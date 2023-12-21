package com.appdev.techno.ie.nurturehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.techno.ie.nurturehub.Entity.AdminEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
	AdminEntity findByUsernameAndIsDeleted(String username, int isDeleted);
}
