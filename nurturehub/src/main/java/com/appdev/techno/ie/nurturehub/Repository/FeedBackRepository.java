package com.appdev.techno.ie.nurturehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appdev.techno.ie.nurturehub.Entity.FeedBackEntity;
import java.util.List;
@Repository
public interface FeedBackRepository extends JpaRepository<FeedBackEntity, Integer> {

    List<FeedBackEntity> findByRecipientId(int recipientId);
    List<FeedBackEntity> findByCaregiverIdAndIsDeleted(int recipientId, int isDeleted);
}
