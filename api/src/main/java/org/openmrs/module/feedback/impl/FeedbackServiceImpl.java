package org.openmrs.module.feedback.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.APIException;
import org.openmrs.module.feedback.FeedbackPredefinedSubject;
import org.openmrs.module.feedback.FeedbackSeverity;
import org.openmrs.module.feedback.HelloWorldResponse;
import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.module.feedback.FeedbackStatus;
import org.openmrs.module.feedback.db.FeedbackDAO;

/**
 * Feedback severity related services
 * 
 * @author Gaurav Paliwal
 * @vesrion 1.0
 */
public class FeedbackServiceImpl implements FeedbackService {

	private Log log = LogFactory.getLog(this.getClass());
	
	private FeedbackDAO dao;
	
	public FeedbackServiceImpl() {	}
	
	private FeedbackDAO getHelloWorldDAO() {
		return dao;
	}
	
	public void setHelloWorldDAO(FeedbackDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * Creates a new helloWorldResponse record
	 * 
	 * @param helloWorldResponse to be created
	 * @throws APIException
	 */
	public void createHelloWorldResponse(HelloWorldResponse helloWorldResponse) throws APIException {
		getHelloWorldDAO().createHelloWorldResponse(helloWorldResponse);
	}
        
        public void createFeedbackSeverity(FeedbackSeverity feedbackSeverity) throws APIException {
		getHelloWorldDAO().createFeedbackSeverity(feedbackSeverity);
	}
        
        public void createFeedbackStatus(FeedbackStatus feedbackStatus) throws APIException {
		getHelloWorldDAO().createFeedbackStatus(feedbackStatus);
	}
        
        public void createFeedbackPredefinedSubject(FeedbackPredefinedSubject feedbackPredefinedSubject) throws APIException {
		getHelloWorldDAO().createFeedbackPredefinedSubject(feedbackPredefinedSubject);
	}
	/**
	 * Get helloWorldResponse by internal identifier
	 * 
	 * @param helloWorldResponseId internal helloWorldResponse identifier
	 * @return helloWorldResponse with given internal identifier
	 * @throws APIException
	 */
	public HelloWorldResponse getHelloWorldResponse(Integer helloWorldResponseId) throws APIException {
		return getHelloWorldDAO().getHelloWorldResponse(helloWorldResponseId);
	}
        
        public FeedbackSeverity getFeedbackSeverity (Integer index) throws APIException {
		return getHelloWorldDAO().getFeedbackSeverity(index) ;
	}
        public FeedbackStatus getFeedbackStatus (Integer index) throws APIException {
		return getHelloWorldDAO().getFeedbackStatus (index) ;
	}

	/**
	 * Update helloWorldResponse 
	 * 
	 * @param helloWorldResponse to be updated
	 * @throws APIException
	 */
	public void updateHelloWorldResponse(HelloWorldResponse helloWorldResponse) throws APIException {
		getHelloWorldDAO().updateHelloWorldResponse(helloWorldResponse);
	}
        
	public void updateFeedbackSeverity(FeedbackSeverity feedbackSeverity) throws APIException {
                getHelloWorldDAO().updateFeedbackSeverity(feedbackSeverity);
        }
        
        public void updateFeedbackStatus (FeedbackStatus feedbackStatus) throws APIException {
                getHelloWorldDAO().updateFeedbackStatus(feedbackStatus) ;
        }
	/**
	 * Get helloWorldResponses
	 * 
	 * @return helloWorldResponse list
	 * @throws APIException
	 */
	public List<HelloWorldResponse> getResponses() throws APIException {
		return getHelloWorldDAO().getResponses();
	}
         public List<FeedbackSeverity> getSeverities() throws APIException {
		return getHelloWorldDAO().getSeverities();
	}
         
        public List<FeedbackStatus> getStatuses() throws APIException {
		return getHelloWorldDAO().getStatuses();
	}

    
	
}
