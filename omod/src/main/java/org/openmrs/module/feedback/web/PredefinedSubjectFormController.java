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
                        
                        PredefinedSubject s = new PredefinedSubject() ;
                        s = service.getFeedbackPredefinedSubject(Integer.parseInt(request.getParameter("predefinedsubjectid"))) ;
                        service.deleteFeedbackPredefinedSubject( s );
                    }
                    
                   else if (request.getParameter("predefinedsubjectid") != null && request.getParameter("save")!= null )
                    {
                        
                        PredefinedSubject s = new PredefinedSubject() ;
                        s = service.getFeedbackPredefinedSubject(Integer.parseInt(request.getParameter("predefinedsubjectid"))) ;
                        s.setSubject(request.getParameter("predefinedsubject") );
                        service.saveFeedbackPredefinedSubject(s);
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
                    PredefinedSubject s = new PredefinedSubject() ;
                    map.put("predefinedsubjects" , s ) ;
                    map.put("status" , "Element Deleted or Do not Exists") ;
                    return map ;
                }
                else if (req.getParameter("predefinedsubjectid") != null)
                {
                                 
                    PredefinedSubject s = new PredefinedSubject() ;
                    s = service.getFeedbackPredefinedSubject(Integer.parseInt(req.getParameter("predefinedsubjectid"))) ;
                    map.put("predefinedsubjects" , s ) ;
                    map.put("status" , "") ;
                    return map ;
                    
                }
		map.put("predefinedsubjects", hService.getPredefinedSubjects()) ;
		return map;
		
	}
	
}
