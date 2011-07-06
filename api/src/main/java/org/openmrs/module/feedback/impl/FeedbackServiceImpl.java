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
	
	public FeedbackServiceImpl() {	
        }
	
	private FeedbackDAO getFeedbackdDAO() {
		return dao;
	}
	
	public void setFeedbackdDAO(FeedbackDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * Creates a new helloWorldResponse record
	 * 
	 * @param helloWorldResponse to be created
	 * @throws APIException
	 */
        
        public void saveSeverity(Severity Severity) throws APIException {
		getFeedbackdDAO().saveSeverity(Severity);
	}
        
        public void saveStatus(Status Status) throws APIException {
		getFeedbackdDAO().saveStatus(Status);
	}
        
        public void savePredefinedSubject(PredefinedSubject PredefinedSubject) throws APIException {
		getFeedbackdDAO().savePredefinedSubject(PredefinedSubject);
	}
        
        public void saveFeedback(Feedback Feedback) throws APIException {
		getFeedbackdDAO().saveFeedback(Feedback);
	}
        
        

  
        public Severity getSeverity (Integer SeverityId) throws APIException {
		return getFeedbackdDAO().getSeverity(SeverityId) ;
	}
        public Status getStatus (Integer StatusId) throws APIException {
		return getFeedbackdDAO().getStatus (StatusId) ;
	}
        
        public PredefinedSubject getPredefinedSubject (Integer PredefinedSubjectId) throws APIException {
		return getFeedbackdDAO().getPredefinedSubject (PredefinedSubjectId) ;
	}
        
        public Feedback getFeedback (Integer FeedbackId) throws APIException {
		return getFeedbackdDAO().getFeedback (FeedbackId) ;
	}



	public void updateSeverity(Severity Severity) throws APIException {
                getFeedbackdDAO().updateSeverity(Severity);
        }
        
        public void updateStatus (Status Status) throws APIException {
                getFeedbackdDAO().updateStatus(Status) ;
        }
        
        public void updatePredefinedSubject (PredefinedSubject PredefinedSubject) throws APIException {
                getFeedbackdDAO().updatePredefinedSubject (PredefinedSubject) ;
        }
        
        public void updateFeedback (Feedback Feedback) throws APIException {
                getFeedbackdDAO().updateFeedback (Feedback) ;
        }


         public List<Severity> getSeverities() throws APIException {
		return getFeedbackdDAO().getSeverities();
	}
         
        public List<Status> getStatuses() throws APIException {
		return getFeedbackdDAO().getStatuses();
	}
        public List<PredefinedSubject> getPredefinedSubjects () throws APIException {
		return getFeedbackdDAO().getPredefinedSubjects();
	}
        public List<Feedback> getFeedbacks () throws APIException {
		return getFeedbackdDAO().getFeedbacks();
	}

        public void deletePredefinedSubject(PredefinedSubject PredefinedSubject) throws APIException {
                getFeedbackdDAO().deletePredefinedSubject(PredefinedSubject); 
        }

        public void deleteStatus(Status Status) throws APIException {
                getFeedbackdDAO().deleteStatus(Status) ;
        }
    
        public void deleteSeverity(Severity Severity) throws APIException {
                getFeedbackdDAO().deleteSeverity(Severity); 
        }

        public void deleteFeedback (Feedback Feedback) throws APIException {
                getFeedbackdDAO().deleteFeedback (Feedback); 
        }   
    
}