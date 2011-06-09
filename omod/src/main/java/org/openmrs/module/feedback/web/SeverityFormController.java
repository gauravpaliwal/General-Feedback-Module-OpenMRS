package org.openmrs.module.feedback.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackSeverity;
import org.openmrs.module.feedback.FeedbackService;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class SeverityFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
            
                        Object o = Context.getService(FeedbackService.class);
                        FeedbackService service = (FeedbackService)o;                 
                    if ( (String)request.getParameter("feedbackSeverityId") == "" || service.getFeedbackSeverity(Integer.parseInt(request.getParameter("feedbackSeverityId"))) == null )
                {
                    System.out.println ("Nothing to do elemented already deleted") ;
                    
                } 
                    
                  else if (request.getParameter("feedbackSeverityId") != null && request.getParameter("delete")!= null )
                    {
                        
                        FeedbackSeverity s = new FeedbackSeverity() ;
                        s = service.getFeedbackSeverity(Integer.parseInt(request.getParameter("feedbackSeverityId"))) ;
                        service.deleteFeedbackSeverity( s );
                    }
                
                
                			
		String text = "Not used";
		
		log.debug("Returning hello world text: " + text);
		
		return text;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Object o = Context.getService(FeedbackService.class);
                FeedbackService service = (FeedbackService)o;    
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
                if ( (String)req.getParameter("feedbackSeverityId") == "" ||  service.getFeedbackSeverity(Integer.parseInt(req.getParameter("feedbackSeverityId"))) == null )
                {
                    System.out.println ("Nothing to do, element  already deleted") ;
                    FeedbackSeverity s = new FeedbackSeverity() ;
                    map.put("feedbackSeverityId" , s ) ;
                    map.put("status" , "Element Deleted or Do not Exists") ;
                    return map ;
                }
                else if (req.getParameter("feedbackSeverityId") != null)
                {
                                 
                    FeedbackSeverity s = new FeedbackSeverity() ;
                    s = service.getFeedbackSeverity(Integer.parseInt(req.getParameter("feedbackSeverityId"))) ;
                    map.put("severity" , s ) ;
                    map.put("status" , "") ;
                    return map ;
                    
                }
		map.put("severity", hService.getSeverities()) ;
		return map;
		
	}
	
}
