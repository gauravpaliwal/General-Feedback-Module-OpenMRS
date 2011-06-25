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

public class AddPredefinedSubjectFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
            
                String text = "Not used";
		
                if (request.getParameter("predefinedsubject") != null && !"".equals(request.getParameter("predefinedsubject")) )
                {
                    Object o = Context.getService(FeedbackService.class);
                    FeedbackService service = (FeedbackService)o;                 
                    PredefinedSubject s = new PredefinedSubject() ;
                    /** This makes sure that the Predefined Subject value always remain less then or equal to 50*/
                    
                    if ( request.getParameter("predefinedsubject").length()>50 )
                    {
                        s.setSubject((request.getParameter("predefinedsubject")).substring( 1, 50 ) ) ;
        
                    }
                    else 
                    {
                         s.setSubject(request.getParameter("predefinedsubject") ) ;
                    }
                     
                    service.saveFeedbackPredefinedSubject(s) ;
                    
                    /** Notifies to the Controller that the predefined subject has been successfully added with the help of get status param */
                    text = "added";

                }
                
		
		log.debug("Returning hello world text: " + text);
		
		return text;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
		map.put("predefinedsubjects", hService.getPredefinedSubjects()) ;
                if ("added".equals(req.getParameter("status")))
                {
                        map.put("status" , "feedback.notification.predefinedSubject.added" ) ;
                }
                else
                {
                    map.put("status" , "" ) ;
                }
		return map;
		
	}
	
}
        
        
