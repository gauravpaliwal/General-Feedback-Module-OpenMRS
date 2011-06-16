package org.openmrs.module.feedback.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.Feedback;
import org.openmrs.module.feedback.FeedbackService;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class FeedbackFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
		
                if (request.getParameter("status") != null && request.getParameter("comment") != null  )
                {
                    Object o = Context.getService(FeedbackService.class);
                    FeedbackService service = (FeedbackService)o;                       
                    Feedback s = new Feedback() ;
                    s = service.getFeedbackFeedback((Integer.parseInt (request.getParameter("feedbackId" ) ))) ;
                    s.setStatus( request.getParameter("status"));
                    s.setComment( request.getParameter("comment"));
                    service.saveFeedbackFeedback( s );
                }
                			
		String feedbackId = request.getParameter("feedbackId" ) ;
		
		log.debug("Returning hello world text: " + feedbackId);
		
		return feedbackId;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
                if ( req.getParameter("feedbackId" )  != null)
                {
                    map.put("feedback", hService.getFeedbackFeedback( (Integer.parseInt (req.getParameter("feedbackId" ) )) ) ) ;		
                    map.put("status", hService.getStatuses() ) ;		

                }
                
                 return map;
		
	}
	
}