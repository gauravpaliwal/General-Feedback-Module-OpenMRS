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
import org.openmrs.User;
import org.openmrs.module.feedback.PredefinedSubject;
import org.openmrs.module.feedback.Severity ;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.feedback.Feedback;
import org.openmrs.module.feedback.FeedbackComment;
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
        public void saveSeverity(Severity Severity) throws DAOException;
        public void saveStatus(Status Status) throws DAOException;
        public void savePredefinedSubject(PredefinedSubject PredefinedSubject) throws DAOException;
        public void saveFeedback( Feedback Feedback) throws DAOException;
	public void saveFeedbackComment( FeedbackComment FeedbackComment) throws DAOException;

	/**
	 * Get GeneralFeedbackModule by internal identifier
	 * 
	 * @param GeneralFeedbackModule internal identifier
	 * @return GeneralFeedbackModule with given internal identifier
	 * @throws DAOException
	 */
        public Severity getSeverity (Integer SeverityId) throws DAOException;
        public Status getStatus (Integer StatusId) throws DAOException;
        public PredefinedSubject getPredefinedSubject (Integer PredefinedSubjectId) throws DAOException;
        public Feedback getFeedback (Integer FeedbackId) throws DAOException;

	/**
	 * Update GeneralFeedbackModule 
	 * 
	 * @param GeneralFeedbackModule to be updated
	 * @throws DAOException
	 */
	public void updateSeverity(Severity Severity) throws DAOException ;
	public void updateStatus(Status Status) throws DAOException ;
        public void updatePredefinedSubject(PredefinedSubject PredefinedSubject) throws DAOException ;
        public void updateFeedback (Feedback Feedback) throws DAOException ;

        public List<Severity> getSeverities() throws DAOException ;
        public List<Status> getStatuses() throws DAOException ;
        public List<PredefinedSubject> getPredefinedSubjects() throws DAOException ;
        public List<Feedback> getFeedbacks() throws DAOException ;
	public List<Feedback> getFeedbacks(User user) throws DAOException ;
	public List<FeedbackComment> getFeedbackComments(String feedbackId) throws DAOException ;


        public void deletePredefinedSubject(PredefinedSubject PredefinedSubject) throws DAOException ;
        public void deleteStatus(Status Status) throws DAOException ;
        public void deleteSeverity(Severity Severity) throws DAOException ;
        public void deleteFeedback(Feedback Feedback) throws DAOException ;


}
