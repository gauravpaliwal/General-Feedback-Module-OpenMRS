/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.feedback.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.Status ;
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
                        
                        Status s = new Status() ;
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
                    Status s = new Status() ;
                    map.put("statuses" , s ) ;
                    map.put("status" , "Element Deleted or Do not Exists") ;
                    return map ;
                }
                else if (req.getParameter("feedbackStatusId") != null)
                {
                                 
                    Status  s = new Status () ;
                    s = service.getFeedbackStatus(Integer.parseInt(req.getParameter("feedbackStatusId"))) ;
                    System.out.println(s.getfeedbackStatusId()) ;
                    map.put("statuses" , s ) ;
                    map.put("status" , "") ;
                    return map ;
                    
                }
		map.put("statuses", hService.getStatuses()) ;
		return map;
		
	}
	
}