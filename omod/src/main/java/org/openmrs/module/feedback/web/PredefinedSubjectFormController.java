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
import org.openmrs.module.feedback.PredefinedSubject;
import org.openmrs.module.feedback.FeedbackService;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class PredefinedSubjectFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
            
                    Object o = Context.getService(FeedbackService.class);
                    FeedbackService service = (FeedbackService)o;        
                    String text = "Not used";
                    String predefinedsubjectid = request.getParameter("predefinedsubjectid") ;
                    
                    if ( !StringUtils.hasLength(predefinedsubjectid) || service.getPredefinedSubject(Integer.parseInt(predefinedsubjectid)) == null )
                    {
                        /*Just log this for the statistics */
                        System.out.println ("feedback.notification.predefinedSubject.deleted") ;
                    
                    } 
                    
                    else if (predefinedsubjectid != null && request.getParameter("delete")!= null )
                    {
                        /*delete the element*/
                        PredefinedSubject s = new PredefinedSubject() ;
                        s = service.getPredefinedSubject(Integer.parseInt(predefinedsubjectid)) ;
                        service.deletePredefinedSubject( s );
                    }
                    
                    else if (predefinedsubjectid != null && request.getParameter("save")!= null )
                    {
                        /*save the element*/
                        PredefinedSubject s = new PredefinedSubject() ;
                        s = service.getPredefinedSubject(Integer.parseInt(predefinedsubjectid)) ;
                        
                        /** This makes sure that the Predefined Subject value always remain less then or equal to 50*/
                        s.setSubject(request.getParameter("predefinedsubject") ) ;
                        
                        /*Service Method to save the data*/
                        service.savePredefinedSubject(s) ;                              
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
                String predefinedsubjectid = req.getParameter("predefinedsubjectid") ;
                
                /*Predefined Subject is deleted incase the subject with predefinedID is not found*/
                if ( !StringUtils.hasLength( predefinedsubjectid) ||  service.getPredefinedSubject(Integer.parseInt(predefinedsubjectid)) == null )
                {
                    PredefinedSubject s = new PredefinedSubject() ;
                    map.put("predefinedsubjects" , s ) ;
                    map.put("feedbackPageMessage" , "feedback.notification.predefinedSubject.deleted") ;
                    return map ;
                }
                /*Otherwise give the data about the predefined subject*/
                else 
                {   
                    PredefinedSubject s = new PredefinedSubject() ;
                    s = service.getPredefinedSubject(Integer.parseInt(predefinedsubjectid)) ;
                    map.put("predefinedsubjects" , s ) ;
                    map.put("feedbackPageMessage" , "") ;
                    return map ;   
                }

                
		
	}
	
}
