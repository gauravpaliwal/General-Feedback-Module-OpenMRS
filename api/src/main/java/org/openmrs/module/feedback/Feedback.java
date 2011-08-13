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

//~--- non-JDK imports --------------------------------------------------------

import org.openmrs.Auditable;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.User;

//~--- JDK imports ------------------------------------------------------------

import java.util.Date;

/*
Pojo file for feedback_feedback relation in Feedback Module
*/
public class Feedback extends BaseOpenmrsObject implements Auditable {
    private User    changedBy;
    private String  comment;
    private String  content;
    private User    creator;
    private Date    dateChanged;
    private Date    dateCreated;
    private Integer feedbackId;
    private byte[]  message;

    /*
     *     Default no arguement constructor
     */
    private String severity;
    private String status;
    private String subject;

    public Feedback() {}

    /*
     *     Constructor with all arguments
     */
    public Feedback(String subject, String content, String severity, Date dateCreated) {
        this.subject     = subject;
        this.content     = content;
        this.severity    = severity;
        this.dateCreated = dateCreated;
    }

    /*
     *     Default constructor with arguments that can't be Null
     */
    public Feedback(String subject, String content, String severity, String comment, String status, Date dateCreated,
                    Date dateChanged) {
        this.subject     = subject;
        this.content     = content;
        this.severity    = severity;
        this.comment     = comment;
        this.status      = status;
        this.dateCreated = dateCreated;
        this.dateChanged = dateChanged;
    }

    public Integer getFeedbackId() {
        return this.feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        if (content.length() > 16777215) {
            this.content = content.substring(0, 16777214);
        } else {
            this.content = content;
        }

        this.content = content;
    }

    public String getSeverity() {
        return this.severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getId() {
        return this.feedbackId;
    }

    public void setId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public User getCreator() {
        return this.creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getChangedBy() {
        return this.changedBy;
    }

    public void setChangedBy(User creator) {
        this.changedBy = creator;
    }

    public byte[] getMessage() {
        return message;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
