package com.appdev.techno.ie.nurturehub.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appdev.techno.ie.nurturehub.Entity.AccountEntity;
import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
	AccountEntity findByUsername(String username);
	void deleteByUsername(String username);
	AccountEntity findByUsernameAndIsDeleted(String username, int isDeleted);
	
	@Query("SELECT a FROM AccountEntity a WHERE CONCAT(a.firstname, ' ', a.lastname) LIKE %:combinedName% AND a.isDeleted = :isDeleted")
    List<AccountEntity> findByCombinedNameAndIsDeleted(@Param("combinedName") String combinedName,@Param("isDeleted") int isDeleted);
}
