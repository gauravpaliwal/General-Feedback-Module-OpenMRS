package org.openmrs.module.feedback;

/**
 * Pojo file for the feedback.status relation in the Feedback Module
 */
public class FeedbackStatus  implements java.io.Serializable {


     private Integer feedbackStatusId;
     private String status;

    /*
      * Default constructor for the class
    */ 
    
    public FeedbackStatus() {
    }

    /*
     * Contructor with status as arguement
    */
    public FeedbackStatus(String status) {
       this.status = status;
    }
   
    public Integer getfeedbackStatusId() {
        return this.feedbackStatusId;
    }
    
    public void setfeedbackStatusId(Integer feedbackStatusId) {
        this.feedbackStatusId = feedbackStatusId;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


