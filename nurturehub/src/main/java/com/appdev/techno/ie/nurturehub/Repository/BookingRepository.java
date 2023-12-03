package com.appdev.techno.ie.nurturehub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.techno.ie.nurturehub.Entity.BookingEntity;
import com.appdev.techno.ie.nurturehub.Entity.CaregiverEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
	List<BookingEntity> findByCaregiver(String caregiver);
}
