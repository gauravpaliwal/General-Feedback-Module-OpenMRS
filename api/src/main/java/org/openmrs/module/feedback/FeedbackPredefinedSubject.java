package org.openmrs.module.feedback;

/*
 * Pojo file for the feedback.feedback_predefined_subject relation 
 * 
 */
public class FeedbackPredefinedSubject  implements java.io.Serializable {


     private Integer feedbackPredefinedSubjectId;
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
   
    public Integer getfeedbackPredefinedSubjectId() {
        return this.feedbackPredefinedSubjectId;
    }
    
    public void setfeedbackPredefinedSubjectId(Integer feedbackPredefinedSubjectId) {
        this.feedbackPredefinedSubjectId = feedbackPredefinedSubjectId;
    }
    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }




}


