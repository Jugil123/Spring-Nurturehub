package com.appdev.techno.ie.nurturehub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;
import com.appdev.techno.ie.nurturehub.Entity.RecipientEntity;

@Repository
public interface CaregiverRepository extends JpaRepository<CaregiverEntity, Integer>{
	CaregiverEntity findByUsername(String username);
	@Query("SELECT c FROM CaregiverEntity c WHERE CONCAT(c.firstname, ' ', c.lastname) LIKE %:combinedName%")
    List<CaregiverEntity> findByCombinedName(@Param("combinedName") String combinedName);
}
 