package org.openmrs.module.feedback.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.SessionFactory;

import org.openmrs.api.db.DAOException;
import org.openmrs.module.feedback.FeedbackPredefinedSubject;
import org.openmrs.module.feedback.FeedbackSeverity;
import org.openmrs.module.feedback.FeedbackStatus;
import org.openmrs.module.feedback.HelloWorldResponse;
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
	public HelloWorldResponse getHelloWorldResponse(Integer helloWorldResponseId) {
		return (HelloWorldResponse) sessionFactory.getCurrentSession().get(HelloWorldResponse.class, helloWorldResponseId);
	}
        
        public FeedbackSeverity getFeedbackSeverity(Integer feedbackSeverityId) {
		return (FeedbackSeverity) sessionFactory.getCurrentSession().get(FeedbackSeverity.class, feedbackSeverityId);
	}
        
        public FeedbackStatus getFeedbackStatus(Integer feedbackStatusId) {
		return (FeedbackStatus) sessionFactory.getCurrentSession().get(FeedbackStatus.class, feedbackStatusId);
	}
        
        public FeedbackPredefinedSubject getFeedbackPredefinedSubject (Integer feedbackPredefinedSubjectId) {
		return (FeedbackPredefinedSubject) sessionFactory.getCurrentSession().get(FeedbackPredefinedSubject.class, feedbackPredefinedSubjectId);
	}
        
	
	public void createHelloWorldResponse(HelloWorldResponse helloWorldResponse) throws DAOException {
		sessionFactory.getCurrentSession().saveOrUpdate(helloWorldResponse);
	}

        public void createFeedbackSeverity(FeedbackSeverity feedbackSeverity) throws DAOException {
            sessionFactory.getCurrentSession().saveOrUpdate(feedbackSeverity);
        }
        public void createFeedbackStatus(FeedbackStatus feedbackStatus) throws DAOException {
            
            sessionFactory.getCurrentSession().saveOrUpdate(feedbackStatus);

        }   
        
        public void createFeedbackPredefinedSubject (FeedbackPredefinedSubject feedbackPredefinedSubject) throws DAOException {
            
            sessionFactory.getCurrentSession().saveOrUpdate(feedbackPredefinedSubject);

        }   

	public void updateHelloWorldResponse(HelloWorldResponse helloWorldResponse) throws DAOException {
		if (helloWorldResponse.getHelloWorldResponseId() == null)
			createHelloWorldResponse(helloWorldResponse);
		else {
			helloWorldResponse = (HelloWorldResponse)sessionFactory.getCurrentSession().merge(helloWorldResponse);
			sessionFactory.getCurrentSession().saveOrUpdate(helloWorldResponse);
		}
	}
        
         public void updateFeedbackSeverity(FeedbackSeverity feedbackSeverity) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackSeverity);
           
        }
	public void updateFeedbackStatus(FeedbackStatus feedbackStatus) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackStatus);
           
        }
        public void updateFeedbackPredefinedSubject (FeedbackPredefinedSubject feedbackPredefinedSubject) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackPredefinedSubject);
           
        }
	
	@SuppressWarnings("unchecked")
	public List<HelloWorldResponse> getResponses() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(HelloWorldResponse.class).list();
	}
        public List<FeedbackSeverity> getSeverities() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(FeedbackSeverity.class).list();
	}
        public List<FeedbackStatus> getStatuses() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(FeedbackStatus.class).list();
	}
        public List<FeedbackPredefinedSubject> getPredefinedSubjects() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(FeedbackPredefinedSubject.class).list();
	}

        public void deleteFeedbackPredefinedSubject (FeedbackPredefinedSubject feedbackPredefinedSubject) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackPredefinedSubject);           
        }

        public void deleteFeedbackStatus (FeedbackStatus feedbackStatus) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackStatus);          
        }
        
        public void deleteFeedbackSeverity (FeedbackSeverity feedbackSeverity) throws DAOException {
                        sessionFactory.getCurrentSession().delete(feedbackSeverity);          
        }
   
}
