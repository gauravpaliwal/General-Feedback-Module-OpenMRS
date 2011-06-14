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

import java.util.List;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.module.feedback.db.FeedbackDAO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FeedbackService {

	public void setHelloWorldDAO(FeedbackDAO dao);

	/**
	 * Saves (creates) a new feedback module data
	 * 
	 * @param saying to be created
	 * @throws APIException
	 */
	@Authorized({"Add Feedback Criteria"})
        public void saveFeedbackSeverity (Severity feedbackSeverity) throws APIException;
        public void saveFeedbackStatus (Status feedbackstatus ) throws APIException;
        public void saveFeedbackPredefinedSubject (PredefinedSubject feedbackPredefinedSubject ) throws APIException;
        public void saveFeedbackFeedback (Feedback feedbackFeedback) throws APIException;
	/**
	 * Get response by internal identifier
	 * 
	 * @param responseId internal saying identifier
	 * @return response with given internal identifier
	 * @throws APIException
	 */
	@Authorized({"View Feedback Criteria"})
	@Transactional(readOnly=true)
        public Severity getFeedbackSeverity(Integer feedbackSeverityId) throws APIException;
        public Status getFeedbackStatus(Integer feedbackStatusId) throws APIException;
        public PredefinedSubject getFeedbackPredefinedSubject (Integer feedbackPredefinedSubjectId ) throws APIException;


	/**
	 * Save response
	 * 
	 * @param response to be updated
	 * @throws APIException
	 */
	@Authorized({"Edit Feedback Criteria"})
        public void updateFeedbackSeverity(Severity severity) throws APIException;
        public void updateFeedbackStatus(Status status) throws APIException;
        public void updateFeedbackPredefinedSubject(PredefinedSubject feedbackPredefinedSubject) throws APIException;
        
        public void deleteFeedbackPredefinedSubject(PredefinedSubject feedbackPredefinedSubject) throws APIException;        
        public void deleteFeedbackStatus (Status feedbackStatus) throws APIException;
        public void deleteFeedbackSeverity (Severity feedbackSeverity) throws APIException;

        @Transactional(readOnly=true)
	@Authorized({"View Feedback Criteria"})
        public List<Severity> getSeverities() throws APIException;
        public List<Status> getStatuses() throws APIException;
        public List<PredefinedSubject> getPredefinedSubjects() throws APIException;
        public List<Feedback> getFeedbacks () throws APIException ;


}