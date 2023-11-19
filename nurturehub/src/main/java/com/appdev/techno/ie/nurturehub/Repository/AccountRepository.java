package com.appdev.techno.ie.nurturehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.techno.ie.nurturehub.Entity.AccountEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
	AccountEntity findByUsername(String username);
	void deleteByUsername(String username);
}
