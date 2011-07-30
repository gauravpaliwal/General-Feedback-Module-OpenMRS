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
import org.openmrs.GlobalProperty;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackService;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class FeedbackPropertiesFormController extends SimpleFormController {
	   /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected Boolean formBackingObject(HttpServletRequest request) throws Exception {
            	String text = "";
                Boolean feedbackMessage = false ;

                /*To make sure that the status is neither NULL nor empty*/
		String feedbackNotification = request.getParameter("feedbackNotification") ;
		String feedbackNotificationEmail = request.getParameter("feedbackNotificationEmail") ;
		if (feedbackNotification != null && StringUtils.hasLength(feedbackNotification) )
                {
			GlobalProperty globalProperty = new GlobalProperty() ;
			globalProperty.setProperty("feedback.notification") ;
			globalProperty.setPropertyValue(feedbackNotification);
			Context.getAdministrationService().setGlobalProperty(globalProperty);
			feedbackMessage = true ;			
                }
		if (feedbackNotificationEmail != null && StringUtils.hasLength(feedbackNotificationEmail) )
                {
			GlobalProperty globalProperty = new GlobalProperty() ;
			globalProperty.setProperty("feedback.notification.email") ;
			globalProperty.setPropertyValue(feedbackNotificationEmail);
			Context.getAdministrationService().setGlobalProperty(globalProperty);
			feedbackMessage = true ;			
                }
		
                			
		
		log.debug("Returning hello world text: " + text);
		
		return feedbackMessage;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();	
                
                /*Display the message that the content is saved*/
                if (req.getParameter("feedbackMessage")!= null && ServletRequestUtils.getBooleanParameter(req, "feedbackMessage")) 
                {
                        map.put("feedbackPageMessage" , "feedback.admin.notification.added" ) ;
                }
                else
                {
                        map.put("feedbackPageMessage" , "" ) ;
                }
		return map;
		
	}
	
}

	

