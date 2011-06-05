package org.openmrs.module.feedback.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackStatus ;
import org.openmrs.module.feedback.FeedbackService;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class StatusFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
            
                        Object o = Context.getService(FeedbackService.class);
                        FeedbackService service = (FeedbackService)o;                 
                    if ( (String)request.getParameter("feedbackStatusId") == "" || service.getFeedbackStatus(Integer.parseInt(request.getParameter("feedbackStatusId"))) == null )
                {
                    System.out.println ("Nothing to do elemented already deleted") ;
                    
                } 
                    
                  else if (request.getParameter("feedbackStatusId") != null && request.getParameter("delete")!= null )
                    {
                        
                        FeedbackStatus s = new FeedbackStatus() ;
                        s = service.getFeedbackStatus(Integer.parseInt(request.getParameter("feedbackStatusId"))) ;
                        service.deleteFeedbackStatus( s );
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
                if ( (String)req.getParameter("feedbackStatusId") == "" ||  service.getFeedbackStatus(Integer.parseInt(req.getParameter("feedbackStatusId"))) == null )
                {
                    System.out.println ("Nothing to do, element  already deleted") ;
                    FeedbackStatus s = new FeedbackStatus() ;
                    map.put("statuses" , s ) ;
                    map.put("status" , "Element deleted or Do not Exists") ;
                    return map ;
                }
                else if (req.getParameter("feedbackStatusId") != null)
                {
                                 
                    FeedbackStatus  s = new FeedbackStatus () ;
                    s = service.getFeedbackStatus(Integer.parseInt(req.getParameter("feedbackStatusId"))) ;
                    System.out.println(s.getfeedbackStatusId()) ;
                    System.out.println("fddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd") ;
                    map.put("statuses" , s ) ;
                    map.put("status" , "") ;
                    return map ;
                    
                }
		map.put("statuses", hService.getStatuses()) ;
		return map;
		
	}
	
}