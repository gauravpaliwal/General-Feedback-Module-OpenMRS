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
		/* Make sure that neither the status not the comment is empty or Null*/
                if (request.getParameter("status") != null && request.getParameter("comment") != null  )
                {
                    Object o = Context.getService(FeedbackService.class);
                    FeedbackService service = (FeedbackService)o;                       
                    Feedback s = service.getFeedback((Integer.parseInt (request.getParameter("feedbackId" ) ))) ;
                    s.setStatus( request.getParameter("status"));
                    s.setComment( request.getParameter("comment"));
                    service.saveFeedback( s );
                }
                			
		String feedbackId = request.getParameter("feedbackId" ) ;
		
		log.debug("Returning feedback text: " + feedbackId);
		
		return feedbackId;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
                /*Make sure that the feedback ID is not empty*/
                if ( req.getParameter("feedbackId" )  != null)
                {   
                    /*This return the feedback object and status to the feedbackform page.*/
                    map.put("feedback", hService.getFeedback( (Integer.parseInt (req.getParameter("feedbackId" ) )) ) ) ;		
                    map.put("statuses", hService.getStatuses() ) ;		
                }
                
                 return map;
		
	}
	
}