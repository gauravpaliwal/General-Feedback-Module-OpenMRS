package org.openmrs.module.feedback.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackSeverity;
import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.module.feedback.FeedbackStatus;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class AddSeverityFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
		
		System.out.println(request.getParameter( "severity" )) ; 
                if (request.getParameter("severity") != null)
                {
                    Object o = Context.getService(FeedbackService.class);
                    FeedbackService service = (FeedbackService)o;                 
                    FeedbackSeverity s = new FeedbackSeverity() ;
                    s.setSeverity(request.getParameter("severity")) ;
                    service.createFeedbackSeverity(s) ;
              
                }
                			
		String text = "Not used";
		
		log.debug("Returning hello world text: " + text);
		
		return text;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
		map.put("severities", hService.getSeverities()) ;
		
		return map;
		
	}
	
}
