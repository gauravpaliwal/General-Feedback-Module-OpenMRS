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
import org.openmrs.module.feedback.Severity;
import org.openmrs.module.feedback.FeedbackService;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class SeverityFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
            
                    String text = "Not used";
                    Object o = Context.getService(FeedbackService.class);
                    FeedbackService service = (FeedbackService)o;                 
                    if ( "".equals((String)request.getParameter("feedbackSeverityId")) || service.getFeedbackSeverity(Integer.parseInt(request.getParameter("feedbackSeverityId"))) == null )
                        {   /*Just for statistics that the elemented is deleted already or do not exists*/
                            System.out.println ("Nothing to do elemented already deleted") ;                    
                        } 
                    /*This is to tell that the item will be deleted incase delete is submitted*/
                    else if (request.getParameter("feedbackSeverityId") != null && request.getParameter("delete")!= null )
                        {                       
                            Severity s = new Severity() ;
                            s = service.getFeedbackSeverity(Integer.parseInt(request.getParameter("feedbackSeverityId"))) ;
                            service.deleteFeedbackSeverity( s );
                        }
                    /*save the severity*/
                    else if (request.getParameter("feedbackSeverityId") != null && request.getParameter("save")!= null )
                        {
                        
                            Severity s = new Severity() ;
                            s = service.getFeedbackSeverity(Integer.parseInt(request.getParameter("feedbackSeverityId"))) ;
                            text = "saved";
                        
                            /** This makes sure that the Severity value always remain less then or equal to 50*/
                    
                            if ( request.getParameter("severity").length()>50 )
                                {
                                    s.setSeverity((request.getParameter("severity")).substring( 1, 50 ) ) ;        
                                }
                            else 
                                {
                                    s.setSeverity(request.getParameter("severity") ) ;
                                }
                     
                            service.saveFeedbackSeverity(s) ;
                        }
                
                         		
		log.debug("Returning hello world text: " + text);
		
		return text;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Object o = Context.getService(FeedbackService.class);
                FeedbackService service = (FeedbackService)o;    
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
                
                /*To display the message that the severity has been deleted*/
                if ( "".equals((String)req.getParameter("feedbackSeverityId")) ||  service.getFeedbackSeverity(Integer.parseInt(req.getParameter("feedbackSeverityId"))) == null )
                {
                    Severity s = new Severity() ;
                    map.put("feedbackSeverityId" , s ) ;
                    map.put("status" , "feedback.notification.severity.deleted") ;
                    return map ;
                }
                else
                {
                    /*Return the severity with the specific feedbackID*/             
                    Severity s = new Severity() ;
                    s = service.getFeedbackSeverity(Integer.parseInt(req.getParameter("feedbackSeverityId"))) ;
                    map.put("severity" , s ) ;
                    map.put("status" , "") ;
                    return map ;
                }

		
	}
	
}
