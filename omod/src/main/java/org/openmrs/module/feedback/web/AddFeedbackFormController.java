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
import org.openmrs.module.feedback.Feedback;
import org.openmrs.module.feedback.FeedbackService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class AddFeedbackFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
            
            /*To check wheather or not the subject , severity and feedback is empty or not*/
		String text = "";

                if (request.getParameter("subject") != null && request.getParameter("severity") != null  && request.getParameter("feedback") != null  )
                {
                    Object o = Context.getService(FeedbackService.class);
                    FeedbackService service = (FeedbackService)o;                 
                    Feedback s = new Feedback() ;
                    s.setSubject(request.getParameter("subject"));
                    s.setSeverity(request.getParameter("severity"));
                    
                    /*To get the Stacktrace of the page from which the feedback is submitted*/
                    
                    StackTraceElement[] c = Thread.currentThread().getStackTrace() ;
                    String feedback =    request.getParameter("feedback")  ;
                    for (int i = 0 ; i < c.length ; i++ ){
                        feedback = feedback + "\n" + c[i].getFileName() + c[i].getMethodName() + c[i].getClass() + c[i].getLineNumber() ;
                    }
                    
                    /*The feedback content length can't be greater then the 5000 characters , in case it is more then that then it is truncated to the first 5000 characters*/

                    s.setContent( feedback );
                    
                    /*file upload in multiplerequest*/
                    if (request instanceof MultipartHttpServletRequest) 
                    {
                        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                        MultipartFile file = (MultipartFile) multipartRequest.getFile("file");
                        s.setMessage(file.getBytes());
                    }
                    /*Save the Feedback*/
                    service.saveFeedback(s) ;  
                    text = "saved";
                }
                /*Reserved for future use for showing that the data is saved and the feedback is submitted*/			
		
		log.debug("Returning hello world text: " + text);
		
		return text;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		/*Return List of Predefined Subjects and Severities for the feedback submission form*/
                
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
		map.put("predefinedsubjects", hService.getPredefinedSubjects()) ;
                map.put("severities", hService.getSeverities() ) ;		
                if ("saved".equals(req.getParameter("status"))) {
                      map.put("status", "feedback.notification.feedback.save" ) ;		
                }
                return map;
		
	}
	
}
