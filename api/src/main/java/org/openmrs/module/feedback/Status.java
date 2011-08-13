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

import org.openmrs.BaseOpenmrsObject;

/**
 * Pojo file for the feedback.status relation in the Feedback Module
 */
public class Status extends BaseOpenmrsObject implements java.io.Serializable {
    private Integer feedbackStatusId;
    private String  status;

    /*
     *  Default constructor for the class
     */
    public Status() {}

    /*
     * Contructor with status as arguement
     */
    public Status(String status) {
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
        if (status.length() > 50) {
            this.status = status.substring(0, 50);
        } else {
            this.status = status;
        }
    }

    public Integer getId() {
        return this.feedbackStatusId;
    }

    public void setId(Integer feedbackStatusId) {
        this.feedbackStatusId = feedbackStatusId;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
