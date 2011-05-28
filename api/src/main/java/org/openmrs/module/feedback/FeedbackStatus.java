package org.openmrs.module.feedback;

/**
 * Pojo file for the feedback.status relation in the Feedback Module
 */
public class FeedbackStatus  implements java.io.Serializable {


     private Integer index;
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
   
    public Integer getIndex() {
        return this.index;
    }
    
    public void setIndex(Integer index) {
        this.index = index;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


