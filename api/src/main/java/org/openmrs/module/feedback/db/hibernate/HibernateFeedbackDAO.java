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


package org.openmrs.module.feedback.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.SessionFactory;

import org.openmrs.api.db.DAOException;
import org.openmrs.module.feedback.Feedback;
import org.openmrs.module.feedback.PredefinedSubject;
import org.openmrs.module.feedback.Severity;
import org.openmrs.module.feedback.Status;
import org.openmrs.module.feedback.db.FeedbackDAO;

public class HibernateFeedbackDAO implements FeedbackDAO {

	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * Hibernate session factory
	 */
	private SessionFactory sessionFactory;
	
	public HibernateFeedbackDAO() { }
	
	/**
	 * Set session factory
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) { 
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @see org.openmrs.api.db.HelloWorldResponseService#getHelloWorldResponse(java.lang.Long)
	 */
        
        public Severity getFeedbackSeverity(Integer feedbackSeverityId) {
		return (Severity) sessionFactory.getCurrentSession().get(Severity.class, feedbackSeverityId);
	}
        
        public Status getFeedbackStatus(Integer feedbackStatusId) {
		return (Status) sessionFactory.getCurrentSession().get(Status.class, feedbackStatusId);
	}
        
        public PredefinedSubject getFeedbackPredefinedSubject (Integer feedbackPredefinedSubjectId) {
		return (PredefinedSubject) sessionFactory.getCurrentSession().get(PredefinedSubject.class, feedbackPredefinedSubjectId);
	}
        
        public Feedback getFeedbackFeedback (Integer feedbackFeedbackId) {
		return (Feedback) sessionFactory.getCurrentSession().get(Feedback.class, feedbackFeedbackId);
	}
        
	

        public void saveFeedbackSeverity(Severity feedbackSeverity) throws DAOException {
            sessionFactory.getCurrentSession().saveOrUpdate(feedbackSeverity);
        }
        
        public void saveFeedbackStatus(Status feedbackStatus) throws DAOException {
            
            sessionFactory.getCurrentSession().saveOrUpdate(feedbackStatus);

        }
        public void saveFeedbackFeedback(Feedback feedbackFeedback) throws DAOException {
            
            sessionFactory.getCurrentSession().saveOrUpdate(feedbackFeedback);

        } 
        public void saveFeedbackPredefinedSubject (PredefinedSubject feedbackPredefinedSubject) throws DAOException {
            
            sessionFactory.getCurrentSession().saveOrUpdate(feedbackPredefinedSubject);

        }   

        
         public void updateFeedbackSeverity(Severity feedbackSeverity) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackSeverity);
           
        }
	public void updateFeedbackStatus(Status feedbackStatus) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackStatus);
           
        }
        public void updateFeedbackPredefinedSubject (PredefinedSubject feedbackPredefinedSubject) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackPredefinedSubject);
           
        }
        public void updateFeedbackFeedback (Feedback feedbackFeedback) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackFeedback);
           
        }
	
	@SuppressWarnings("unchecked")

        public List<Severity> getSeverities() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(Severity.class).list();
	}
        public List<Status> getStatuses() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(Status.class).list();
	}
        public List<PredefinedSubject> getPredefinedSubjects() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(PredefinedSubject.class).list();
	}
        
        public List<Feedback> getFeedbacks() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(Feedback.class).list();
	}
        

        public void deleteFeedbackPredefinedSubject (PredefinedSubject feedbackPredefinedSubject) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackPredefinedSubject);           
        }

        public void deleteFeedbackStatus (Status feedbackStatus) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackStatus);          
        }
        
        public void deleteFeedbackSeverity (Severity feedbackSeverity) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackSeverity);          
        }
        
        public void deleteFeedbackFeedback (Feedback feedbackFeedback) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackFeedback);          
        }

   
}
