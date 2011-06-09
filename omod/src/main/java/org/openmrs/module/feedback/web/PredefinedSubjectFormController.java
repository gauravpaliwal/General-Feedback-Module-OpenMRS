package org.openmrs.module.feedback.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackPredefinedSubject;
import org.openmrs.module.feedback.FeedbackService;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class PredefinedSubjectFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
            
                        Object o = Context.getService(FeedbackService.class);
                        FeedbackService service = (FeedbackService)o;                 
                    if ( (String)request.getParameter("predefinedsubjectid") == "" || service.getFeedbackPredefinedSubject(Integer.parseInt(request.getParameter("predefinedsubjectid"))) == null )
                    {
                        System.out.println ("Nothing to do elemented already deleted") ;
                    
                    } 
                    
                  else if (request.getParameter("predefinedsubjectid") != null && request.getParameter("delete")!= null )
                    {
                        
                        FeedbackPredefinedSubject s = new FeedbackPredefinedSubject() ;
                        s = service.getFeedbackPredefinedSubject(Integer.parseInt(request.getParameter("predefinedsubjectid"))) ;
                        service.deleteFeedbackPredefinedSubject( s );
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
                if ( (String)req.getParameter("predefinedsubjectid") == "" ||  service.getFeedbackPredefinedSubject(Integer.parseInt(req.getParameter("predefinedsubjectid"))) == null )
                {
                    System.out.println ("Nothing to do, element  already deleted") ;
                    FeedbackPredefinedSubject s = new FeedbackPredefinedSubject() ;
                    map.put("predefinedsubjects" , s ) ;
                    map.put("status" , "Element Deleted or Do not Exists") ;
                    return map ;
                }
                else if (req.getParameter("predefinedsubjectid") != null)
                {
                                 
                    FeedbackPredefinedSubject s = new FeedbackPredefinedSubject() ;
                    s = service.getFeedbackPredefinedSubject(Integer.parseInt(req.getParameter("predefinedsubjectid"))) ;
                    map.put("predefinedsubjects" , s ) ;
                    map.put("status" , "") ;
                    return map ;
                    
                }
		map.put("predefinedsubjects", hService.getPredefinedSubjects()) ;
		return map;
		
	}
	
}
