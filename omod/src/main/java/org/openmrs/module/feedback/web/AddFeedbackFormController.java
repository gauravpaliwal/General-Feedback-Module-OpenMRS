package org.openmrs.module.feedback.web;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackFeedback;
import org.openmrs.module.feedback.FeedbackService;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class AddFeedbackFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
		
                if (request.getParameter("subject") != null && request.getParameter("severity") != null  && request.getParameter("feedback") != null  )
                {
                    Object o = Context.getService(FeedbackService.class);
                    FeedbackService service = (FeedbackService)o;                 
                    FeedbackFeedback s = new FeedbackFeedback() ;
                    s.setSubject(request.getParameter("subject"));
                    s.setSeverity(request.getParameter("severity"));
                    s.setContent( request.getParameter("feedback") );
                    s.setCreator(Context.getAuthenticatedUser().getUserId() );
                    Calendar c = Calendar.getInstance() ;
                    s.setDateCreated( c.getTime() ) ;
                    service.createFeedbackFeedback(s) ;

        
                }
                			
		String text = "Not used";
		
		log.debug("Returning hello world text: " + text);
		
		return text;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
		map.put("predefinedsubjects", hService.getPredefinedSubjects()) ;
                map.put("severities", hService.getSeverities() ) ;		
                return map;
		
	}
	
}
