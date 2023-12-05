package com.appdev.techno.ie.nurturehub.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FeedBackEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedbackId;

    @Column(name = "caregiver_id")
    private int caregiverId;

    @Column(name = "recipient_id")
    private int recipientId;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "rating")
    private int rating;


    public FeedBackEntity() {}

    public FeedBackEntity(int caregiverId, int recipientId, String feedback, int rating) {
        this.caregiverId = caregiverId;
        this.recipientId = recipientId;
        this.feedback = feedback;
        this.rating = rating;
    }


    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getCaregiverId() {
        return caregiverId;
    }

    public void setCaregiverId(int caregiverId) {
        this.caregiverId = caregiverId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
