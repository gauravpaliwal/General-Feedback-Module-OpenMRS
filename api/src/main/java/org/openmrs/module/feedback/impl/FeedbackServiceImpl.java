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

package org.openmrs.module.feedback.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.APIException;
import org.openmrs.module.feedback.Feedback;
import org.openmrs.module.feedback.HelloWorldResponse;
import org.openmrs.module.feedback.PredefinedSubject;
import org.openmrs.module.feedback.Severity;
import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.module.feedback.Status;
import org.openmrs.module.feedback.db.FeedbackDAO;

/**
 * Feedback severity related services
 * 
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
        
        public void saveFeedbackSeverity(Severity feedbackSeverity) throws APIException {
		getHelloWorldDAO().saveFeedbackSeverity(feedbackSeverity);
	}
        
        public void saveFeedbackStatus(Status feedbackStatus) throws APIException {
		getHelloWorldDAO().saveFeedbackStatus(feedbackStatus);
	}
        
        public void saveFeedbackPredefinedSubject(PredefinedSubject feedbackPredefinedSubject) throws APIException {
		getHelloWorldDAO().saveFeedbackPredefinedSubject(feedbackPredefinedSubject);
	}
        
        public void saveFeedbackFeedback(Feedback feedbackFeedback) throws APIException {
		getHelloWorldDAO().saveFeedbackFeedback(feedbackFeedback);
	}
        
        
	/**
	 * Get helloWorldResponse by internal identifier
	 * 
	 * @param helloWorldResponseId internal helloWorldResponse identifier
	 * @return helloWorldResponse with given internal identifier
	 * @throws APIException
	 */
  
        public Severity getFeedbackSeverity (Integer feedbackSeverityId) throws APIException {
		return getHelloWorldDAO().getFeedbackSeverity(feedbackSeverityId) ;
	}
        public Status getFeedbackStatus (Integer feedbackStatusId) throws APIException {
		return getHelloWorldDAO().getFeedbackStatus (feedbackStatusId) ;
	}
        
        public PredefinedSubject getFeedbackPredefinedSubject (Integer feedbackPredefinedSubjectId) throws APIException {
		return getHelloWorldDAO().getFeedbackPredefinedSubject (feedbackPredefinedSubjectId) ;
	}
        
        public Feedback getFeedbackFeedback (Integer feedbackFeedbackId) throws APIException {
		return getHelloWorldDAO().getFeedbackFeedback (feedbackFeedbackId) ;
	}

	/**
	 * Update helloWorldResponse 
	 * 
	 * @param helloWorldResponse to be updated
	 * @throws APIException
	 */

	public void updateFeedbackSeverity(Severity feedbackSeverity) throws APIException {
                getHelloWorldDAO().updateFeedbackSeverity(feedbackSeverity);
        }
        
        public void updateFeedbackStatus (Status feedbackStatus) throws APIException {
                getHelloWorldDAO().updateFeedbackStatus(feedbackStatus) ;
        }
        
        public void updateFeedbackPredefinedSubject (PredefinedSubject feedbackPredefinedSubject) throws APIException {
                getHelloWorldDAO().updateFeedbackPredefinedSubject (feedbackPredefinedSubject) ;
        }
        
        public void updateFeedbackFeedback (Feedback feedbackFeedback) throws APIException {
                getHelloWorldDAO().updateFeedbackFeedback (feedbackFeedback) ;
        }
	/**
	 * Get helloWorldResponses
	 * 
	 * @return helloWorldResponse list
	 * @throws APIException
	 */

         public List<Severity> getSeverities() throws APIException {
		return getHelloWorldDAO().getSeverities();
	}
         
        public List<Status> getStatuses() throws APIException {
		return getHelloWorldDAO().getStatuses();
	}
        public List<PredefinedSubject> getPredefinedSubjects () throws APIException {
		return getHelloWorldDAO().getPredefinedSubjects();
	}
        public List<Feedback> getFeedbacks () throws APIException {
		return getHelloWorldDAO().getFeedbacks();
	}

        public void deleteFeedbackPredefinedSubject(PredefinedSubject feedbackPredefinedSubject) throws APIException {
                getHelloWorldDAO().deleteFeedbackPredefinedSubject(feedbackPredefinedSubject); 
        }

        public void deleteFeedbackStatus(Status feedbackStatus) throws APIException {
                getHelloWorldDAO().deleteFeedbackStatus(feedbackStatus) ;
        }
    
        public void deleteFeedbackSeverity(Severity feedbackSeverity) throws APIException {
                getHelloWorldDAO().deleteFeedbackSeverity(feedbackSeverity); 
        }

        public void deleteFeedbackFeedback (Feedback feedbackFeedback) throws APIException {
                getHelloWorldDAO().deleteFeedbackFeedback (feedbackFeedback); 
        }

    public void createHelloWorldResponse(HelloWorldResponse saying) throws APIException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public HelloWorldResponse getHelloWorldResponse(Integer sayingId) throws APIException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateHelloWorldResponse(HelloWorldResponse response) throws APIException {
        throw new UnsupportedOperationException("Not supported yet.");
    }   
    
}
