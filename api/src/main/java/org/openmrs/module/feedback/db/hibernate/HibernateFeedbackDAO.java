package org.openmrs.module.feedback.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.feedback.FeedbackSeverity;
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
	

	public void createHelloWorldResponse(HelloWorldResponse helloWorldResponse) throws DAOException {
		sessionFactory.getCurrentSession().saveOrUpdate(helloWorldResponse);
	}

        public void createFeedbackSeverity(FeedbackSeverity feedbackSeverity) throws DAOException {
            sessionFactory.getCurrentSession().saveOrUpdate(feedbackSeverity);
        }


	public void updateHelloWorldResponse(HelloWorldResponse helloWorldResponse) throws DAOException {
		if (helloWorldResponse.getHelloWorldResponseId() == null)
			createHelloWorldResponse(helloWorldResponse);
		else {
			helloWorldResponse = (HelloWorldResponse)sessionFactory.getCurrentSession().merge(helloWorldResponse);
			sessionFactory.getCurrentSession().saveOrUpdate(helloWorldResponse);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<HelloWorldResponse> getResponses() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(HelloWorldResponse.class).list();
	}
        public List<FeedbackSeverity> getSeverities() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(FeedbackSeverity.class).list();
	}
}
