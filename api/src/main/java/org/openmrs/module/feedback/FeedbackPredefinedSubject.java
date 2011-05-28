package org.openmrs.module.feedback;

/*
 * Pojo file for the feedback.feedback_predefined_subject relation 
 * 
 */
public class FeedbackPredefinedSubject  implements java.io.Serializable {


     private Integer index;
     private String subject;

     /*
      *     No Arguement default contructor
     */
    public FeedbackPredefinedSubject() {
    }
    
    /*
     * Contructor with the arguement that can't be null
    */

    public FeedbackPredefinedSubject(String subject) {
       this.subject = subject;
    }
   
    public Integer getIndex() {
        return this.index;
    }
    
    public void setIndex(Integer index) {
        this.index = index;
    }
    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }




}


