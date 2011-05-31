package org.openmrs.module.feedback;

/**
 * Feedback Module Severity
 * 
 * @version 1.0
 */

public class FeedbackSeverity  implements java.io.Serializable {

    public static final long serialVersionUID = 113222232L;

     private int feedbackSeverityId;
     private String severity;
     
     /*Default Contructor*/

    public FeedbackSeverity() {
    }
    
    /*Constructor with the parameter*/

    public FeedbackSeverity(int feedbackSeverityId, String severity) {
       this.feedbackSeverityId = feedbackSeverityId;
       this.severity = severity;
    }
   
    public int getfeedbackSeverityId() {
        return this.feedbackSeverityId;
    }
    
    public void setfeedbackSeverityId(int feedbackSeverityId) {
        this.feedbackSeverityId = feedbackSeverityId;
    }
    public String getSeverity() {
        return this.severity;
    }
    
    public void setSeverity(String severity) {
        this.severity = severity;
    }




}


