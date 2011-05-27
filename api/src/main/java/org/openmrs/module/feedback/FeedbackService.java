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

	/**
	 * Save response
	 * 
	 * @param response to be updated
	 * @throws APIException
	 */
	@Authorized({"Edit Hello World Response"})
	public void updateHelloWorldResponse(HelloWorldResponse response) throws APIException;

	@Authorized({"View Hello World Response"})
	public List<HelloWorldResponse> getResponses() throws APIException;
        public List<FeedbackSeverity> getSeverities() throws APIException;
}