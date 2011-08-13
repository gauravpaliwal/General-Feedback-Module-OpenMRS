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

/*
* Pojo file for the feedback.feedback_predefined_subject relation
*
 */
public class PredefinedSubject extends BaseOpenmrsObject implements java.io.Serializable {
    private Integer feedbackPredefinedSubjectId;
    private Integer sortWeight;
    private String  subject;

    /*
     *     No Arguement default contructor
     */
    public PredefinedSubject() {}

    /*
     * Contructor with the arguement that can't be null
     */
    public PredefinedSubject(String subject) {
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
        if (subject.length() > 50) {
            this.subject = subject.substring(0, 50);
        } else {
            this.subject = subject;
        }
    }

    public Integer getId() {
        return this.feedbackPredefinedSubjectId;
    }

    public void setId(Integer feedbackPredefinedSubjectId) {
        this.feedbackPredefinedSubjectId = feedbackPredefinedSubjectId;
    }

    public Integer getSortWeight() {
        return this.sortWeight;
    }

    public void setSortWeight(Integer sortWeight) {
        this.sortWeight = sortWeight;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
