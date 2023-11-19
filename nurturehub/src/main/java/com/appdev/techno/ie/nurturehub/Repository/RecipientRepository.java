package com.appdev.techno.ie.nurturehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;


@Repository
public interface RecipientRepository extends JpaRepository<RecipientEntity, Integer> {
	RecipientEntity findByUsername(String username);
}
