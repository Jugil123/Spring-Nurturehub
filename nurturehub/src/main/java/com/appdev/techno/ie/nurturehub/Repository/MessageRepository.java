package com.appdev.techno.ie.nurturehub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appdev.techno.ie.nurturehub.Entity.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,Integer> {

	List<MessageEntity> findByMessageKeyAndIsDeleted(String messageKey, int isDeleted);
	
	
	@Query("SELECT m FROM MessageEntity m WHERE m.messageKey LIKE %:partialMessageKey% AND m.isDeleted = :isDeleted")
	List<MessageEntity> findByPartialMessageKeyAndIsDeleted(@Param("partialMessageKey") String partialMessageKey, @Param("isDeleted") int isDeleted);
}
