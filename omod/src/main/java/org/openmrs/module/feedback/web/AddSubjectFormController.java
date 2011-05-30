package org.openmrs.module.feedback.web;
import org.openmrs.module.feedback.web.*;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackSeverity;
import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.module.feedback.FeedbackSeverity;
import org.openmrs.module.feedback.FeedbackStatus;
import org.openmrs.module.feedback.FeedbackStatus;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class AddSubjectFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
		
		System.out.println(request.getParameter( "response" )) ; 
                if (request.getParameter("response") != null)
                {
                    Object o = Context.getService(FeedbackService.class);
                    FeedbackService service = (FeedbackService)o;                 
                    FeedbackSeverity s = new FeedbackSeverity() ;
                    s.setSeverity(request.getParameter("response")) ;
                    service.createFeedbackSeverity(s) ;
                    s = service.getFeedbackSeverity(2) ;
                    FeedbackSeverity k = new FeedbackSeverity() ;
                    FeedbackStatus x = new FeedbackStatus() ;
                    x.setStatus("FsCk");
                    service.createFeedbackStatus(x) ;
                    FeedbackSeverity m = new FeedbackSeverity() ;
                    m = service.getFeedbackSeverity( 3 ) ;
   /*               service.updateFeedbackSeverity(m); */
                    
                    
                    
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
