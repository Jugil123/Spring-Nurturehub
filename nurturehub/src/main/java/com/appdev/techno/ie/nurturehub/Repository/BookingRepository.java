package com.appdev.techno.ie.nurturehub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appdev.techno.ie.nurturehub.Entity.BookingEntity;
import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
	 @Query("SELECT b FROM BookingEntity b WHERE b.caregiver = :caregiver AND b.isTerminated = :isTerminated")
	 List<BookingEntity> findByCaregiverAndIsTerminated(@Param("caregiver") String caregiver, @Param("isTerminated") int isTerminated);
}
