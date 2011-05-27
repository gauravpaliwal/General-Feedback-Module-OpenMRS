package org.openmrs.module.feedback;

/**
 * Feedback Module Severity
 * 
 * @author Gaurav Paliwal
 * @version 1.0
 */

public class FeedbackSeverity  implements java.io.Serializable {

    public static final long serialVersionUID = 113222232L;

     private int index;
     private String severity;
     
     /*Default Contructor*/

    public FeedbackSeverity() {
    }
    
    /*Constructor with the parameter*/

    public FeedbackSeverity(int index, String severity) {
       this.index = index;
       this.severity = severity;
    }
   
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    public String getSeverity() {
        return this.severity;
    }
    
    public void setSeverity(String severity) {
        this.severity = severity;
    }




}


