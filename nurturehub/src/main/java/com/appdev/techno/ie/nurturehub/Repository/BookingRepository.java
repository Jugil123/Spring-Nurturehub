package com.appdev.techno.ie.nurturehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.techno.ie.nurturehub.Entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
	
}
