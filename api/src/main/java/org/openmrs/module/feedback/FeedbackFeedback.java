package org.openmrs.module.feedback;


import java.util.Date;

/*
        Pojo file for feedback_feedback relation in Feedback Module
*/

public class FeedbackFeedback  implements java.io.Serializable {


     private Integer feedbackId;
     private int creator;
     private String subject;
     private String content;
     private String severity;
     private String comment;
     private String status;
     private Date dateCreated;
     private Date dateChanged;
     
     /*
           Default no arguement constructor
     */

    public FeedbackFeedback() {
    }

     /*
           Constructor with all arguments
     */
	
    public FeedbackFeedback(int creator, String subject, String content, String severity, Date dateCreated) {
        this.creator = creator;
        this.subject = subject;
        this.content = content;
        this.severity = severity;
        this.dateCreated = dateCreated;
    }
    
     /*
           Default constructor with arguments that can't be Null
     */
    
    public FeedbackFeedback(int creator, String subject, String content, String severity, String comment, String status, Date dateCreated, Date dateChanged) {
       this.creator = creator;
       this.subject = subject;
       this.content = content;
       this.severity = severity;
       this.comment = comment;
       this.status = status;
       this.dateCreated = dateCreated;
       this.dateChanged = dateChanged;
    }
   
    public Integer getFeedbackId() {
        return this.feedbackId;
    }
    
    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }
    public int getCreator() {
        return this.creator;
    }
    
    public void setCreator(int creator) {
        this.creator = creator;
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




}


