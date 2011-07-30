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

import org.openmrs.BaseOpenmrsObject;

/**
 * Feedback Module Severity
 * 
 * @version 1.0
 */

public class Severity extends BaseOpenmrsObject implements java.io.Serializable {

     private Integer feedbackSeverityId;
     private String severity;
     private Integer sortWeight ;
     
     /*Default Contructor*/

    public Severity() {
    }
    
    /*Constructor with the parameter*/

    public Severity(Integer feedbackSeverityId, String severity, Integer sortWeight ) {
       this.feedbackSeverityId = feedbackSeverityId;
       this.severity = severity;
       this.sortWeight = sortWeight;
    }
   
    public Integer getfeedbackSeverityId() {
        return this.feedbackSeverityId;
    }
    
    public void setfeedbackSeverityId(Integer feedbackSeverityId) {
        this.feedbackSeverityId = feedbackSeverityId;
    }
    public String getSeverity() {
        return this.severity;
    }
    
    public void setSeverity(String severity) {
        if ( severity.length()>50 )
            {
                this.severity = severity.substring( 0, 50 ) ;
        
            }
            else 
            {
                this.severity = severity;
            }                
    }


    public Integer getId() {
        return this.feedbackSeverityId;
    }

    public void setId(Integer feedbackSeverityId) {
        this.feedbackSeverityId = feedbackSeverityId ;
    }
    
    public Integer getSortWeight() {
        return this.sortWeight;
    }
    
    public void setSortWeight(Integer sortWeight) {
        this.sortWeight = sortWeight ;
    }


}


