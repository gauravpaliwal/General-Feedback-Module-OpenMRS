package org.openmrs.module.feedback.db;

import java.util.List;
import org.openmrs.module.feedback.FeedbackPredefinedSubject;
import org.openmrs.module.feedback.FeedbackSeverity ;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.feedback.FeedbackFeedback;
import org.openmrs.module.feedback.FeedbackStatus;
import org.openmrs.module.feedback.HelloWorldResponse;

/**
 * HelloWorldResponse-related database functions
 * 
 * @author Ben Wolfe
 * @version 1.0
 */
public interface FeedbackDAO {

	/**
	 * Creates a new helloWorldResponse record
	 * 
	 * @param helloWorldResponse to be created
	 * @throws DAOException
	 */
	public void createHelloWorldResponse(HelloWorldResponse helloWorldResponse) throws DAOException;
        public void createFeedbackSeverity(FeedbackSeverity feedbackSeverity) throws DAOException;
        public void createFeedbackStatus(FeedbackStatus feedbackStatus) throws DAOException;
        public void createFeedbackPredefinedSubject(FeedbackPredefinedSubject feedbackPredefinedSubject) throws DAOException;
        public void createFeedbackFeedback( FeedbackFeedback feedbackFeedback) throws DAOException;

	/**
	 * Get helloWorldResponse by internal identifier
	 * 
	 * @param helloWorldResponseId internal helloWorldResponse identifier
	 * @return helloWorldResponse with given internal identifier
	 * @throws DAOException
	 */
	public HelloWorldResponse getHelloWorldResponse(Integer helloWorldResponseId) throws DAOException;
        public FeedbackSeverity getFeedbackSeverity (Integer feedbackSeverityId) throws DAOException;
        public FeedbackStatus getFeedbackStatus (Integer feedbackStatusId) throws DAOException;
        public FeedbackPredefinedSubject getFeedbackPredefinedSubject (Integer feedbackPredefinedSubjectId) throws DAOException;
        public FeedbackFeedback getFeedbackFeedback (Integer feedbackFeedbackId) throws DAOException;

	/**
	 * Update helloWorldResponse 
	 * 
	 * @param helloWorldResponse to be updated
	 * @throws DAOException
	 */
	public void updateHelloWorldResponse(HelloWorldResponse helloWorldResponse) throws DAOException;
	public void updateFeedbackSeverity(FeedbackSeverity feedbackSeverity) throws DAOException ;
	public void updateFeedbackStatus(FeedbackStatus feedbackStatus) throws DAOException ;
        public void updateFeedbackPredefinedSubject(FeedbackPredefinedSubject feedbackPredefinedSubject) throws DAOException ;
        public void updateFeedbackFeedback (FeedbackFeedback feedbackFeedback) throws DAOException ;

	public List<HelloWorldResponse> getResponses() throws DAOException;
        public List<FeedbackSeverity> getSeverities() throws DAOException ;
        public List<FeedbackStatus> getStatuses() throws DAOException ;
        public List<FeedbackPredefinedSubject> getPredefinedSubjects() throws DAOException ;
        public List<FeedbackFeedback> getFeedbacks() throws DAOException ;


        public void deleteFeedbackPredefinedSubject(FeedbackPredefinedSubject feedbackPredefinedSubject) throws DAOException ;
        public void deleteFeedbackStatus(FeedbackStatus feedbackStatus) throws DAOException ;
        public void deleteFeedbackSeverity(FeedbackSeverity feedbackSeverity) throws DAOException ;
        public void deleteFeedbackFeedback(FeedbackFeedback feedbackFeedback) throws DAOException ;


}
