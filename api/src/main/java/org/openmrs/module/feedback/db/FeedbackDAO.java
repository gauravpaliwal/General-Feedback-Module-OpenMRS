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

package org.openmrs.module.feedback.db;

import java.util.List;
import org.openmrs.module.feedback.PredefinedSubject;
import org.openmrs.module.feedback.Severity ;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.feedback.Feedback;
import org.openmrs.module.feedback.Status;

/**
 * GeneralFeedbackModule-related database functions
 * 
 * @version 1.0
 */
public interface FeedbackDAO {

	/**
	 * Creates a new GeneralFeedbackModule record
	 * 
	 * @param GeneralFeedbackModule to be created
	 * @throws DAOException
	 */
        public void saveFeedbackSeverity(Severity feedbackSeverity) throws DAOException;
        public void saveFeedbackStatus(Status feedbackStatus) throws DAOException;
        public void saveFeedbackPredefinedSubject(PredefinedSubject feedbackPredefinedSubject) throws DAOException;
        public void saveFeedbackFeedback( Feedback feedbackFeedback) throws DAOException;

	/**
	 * Get GeneralFeedbackModule by internal identifier
	 * 
	 * @param GeneralFeedbackModule internal identifier
	 * @return GeneralFeedbackModule with given internal identifier
	 * @throws DAOException
	 */
        public Severity getFeedbackSeverity (Integer feedbackSeverityId) throws DAOException;
        public Status getFeedbackStatus (Integer feedbackStatusId) throws DAOException;
        public PredefinedSubject getFeedbackPredefinedSubject (Integer feedbackPredefinedSubjectId) throws DAOException;
        public Feedback getFeedbackFeedback (Integer feedbackFeedbackId) throws DAOException;

	/**
	 * Update GeneralFeedbackModule 
	 * 
	 * @param GeneralFeedbackModule to be updated
	 * @throws DAOException
	 */
	public void updateFeedbackSeverity(Severity feedbackSeverity) throws DAOException ;
	public void updateFeedbackStatus(Status feedbackStatus) throws DAOException ;
        public void updateFeedbackPredefinedSubject(PredefinedSubject feedbackPredefinedSubject) throws DAOException ;
        public void updateFeedbackFeedback (Feedback feedbackFeedback) throws DAOException ;

        public List<Severity> getSeverities() throws DAOException ;
        public List<Status> getStatuses() throws DAOException ;
        public List<PredefinedSubject> getPredefinedSubjects() throws DAOException ;
        public List<Feedback> getFeedbacks() throws DAOException ;


        public void deleteFeedbackPredefinedSubject(PredefinedSubject feedbackPredefinedSubject) throws DAOException ;
        public void deleteFeedbackStatus(Status feedbackStatus) throws DAOException ;
        public void deleteFeedbackSeverity(Severity feedbackSeverity) throws DAOException ;
        public void deleteFeedbackFeedback(Feedback feedbackFeedback) throws DAOException ;


}
