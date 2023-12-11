package com.appdev.techno.ie.nurturehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appdev.techno.ie.nurturehub.Entity.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,Integer> {

}
