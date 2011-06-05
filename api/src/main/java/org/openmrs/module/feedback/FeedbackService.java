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
	@Authorized({"Add Hello World Response"})
	public void createHelloWorldResponse(HelloWorldResponse saying) throws APIException;
        public void createFeedbackSeverity (FeedbackSeverity feedbackSeverity) throws APIException;
        public void createFeedbackStatus (FeedbackStatus feedbackstatus ) throws APIException;
        public void createFeedbackPredefinedSubject (FeedbackPredefinedSubject feedbackPredefinedSubject ) throws APIException;

	/**
	 * Get response by internal identifier
	 * 
	 * @param responseId internal saying identifier
	 * @return response with given internal identifier
	 * @throws APIException
	 */
	@Authorized({"View Hello World Response"})
	@Transactional(readOnly=true)
	public HelloWorldResponse getHelloWorldResponse(Integer sayingId) throws APIException;
        public FeedbackSeverity getFeedbackSeverity(Integer feedbackSeverityId) throws APIException;
        public FeedbackStatus getFeedbackStatus(Integer feedbackStatusId) throws APIException;
        public FeedbackPredefinedSubject getFeedbackPredefinedSubject (Integer feedbackPredefinedSubjectId ) throws APIException;


	/**
	 * Save response
	 * 
	 * @param response to be updated
	 * @throws APIException
	 */
	@Authorized({"Edit Hello World Response"})
	public void updateHelloWorldResponse(HelloWorldResponse response) throws APIException;
        public void updateFeedbackSeverity(FeedbackSeverity severity) throws APIException;
        public void updateFeedbackStatus(FeedbackStatus status) throws APIException;
        public void updateFeedbackPredefinedSubject(FeedbackPredefinedSubject feedbackPredefinedSubject) throws APIException;
        
        public void deleteFeedbackPredefinedSubject(FeedbackPredefinedSubject feedbackPredefinedSubject) throws APIException;        
        public void deleteFeedbackStatus (FeedbackStatus feedbackStatus) throws APIException;
        public void deleteFeedbackSeverity (FeedbackSeverity feedbackSeverity) throws APIException;

        
	@Authorized({"View Hello World Response"})
	public List<HelloWorldResponse> getResponses() throws APIException;
        public List<FeedbackSeverity> getSeverities() throws APIException;
        public List<FeedbackStatus> getStatuses() throws APIException;
        public List<FeedbackPredefinedSubject> getPredefinedSubjects() throws APIException;

}