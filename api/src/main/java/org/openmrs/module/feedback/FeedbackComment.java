/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.feedback;

import java.util.Date;
import org.openmrs.Auditable;
import org.openmrs.User;

public class FeedbackComment implements Auditable  {


     private Integer feedbackCommentId;
     private User creator;
     private User changedBy ;
     private String comment;
     private Date dateCreated;
     private Date dateChanged;
     private String uuid;
     private byte[] attachment;
     private int feedbackId;

    public FeedbackComment() {
    }

	
    public FeedbackComment(String comment, Date dateCreated, int feedbackId) {
        this.comment = comment;
        this.dateCreated = dateCreated;
        this.feedbackId = feedbackId;
    }
    public FeedbackComment(String comment, byte[] attachment, Date dateCreated , int feedbackId) {
       this.dateCreated = dateCreated;
       this.comment = comment;
       this.attachment = attachment;
       this.feedbackId = feedbackId;
    }
   
    public Integer getFeedbackCommentId() {
        return this.feedbackCommentId;
    }
    
    public void setFeedbackCommentId(Integer feedbackCommentId) {
        this.feedbackCommentId = feedbackCommentId;
    }
    public User getCreator() {
        return this.creator;
    }
    
    public void setCreator(User creator) {
        this.creator = creator;
    }

    
    public void setChangedBy(User changedBy) {
        this.changedBy = changedBy;
    }
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Date getDateChanged() {
        return this.dateChanged;
    }
    
    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }
    public String getUuid() {
        return this.uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public byte[] getAttachment() {
        return this.attachment;
    }
    
    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }
    public int getFeedbackId() {
        return this.feedbackId;
    }
    
    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public User getChangedBy() {
        return this.changedBy ;
    }

    public Integer getId() {
        return this.feedbackId;
    }

    public void setId(Integer feedbackId) {
        this.feedbackId = feedbackId ;
    }
}


