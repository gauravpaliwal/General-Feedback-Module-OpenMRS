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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackService;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class PreferenceFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());
    Pattern pattern  = Pattern.compile(EMAIL_PATTERN) ;;
    private Matcher matcher;
    private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public boolean validate(final String hex)
	{
	matcher = pattern.matcher(hex);
	return matcher.matches();
	}

	@Override
	protected Boolean formBackingObject (HttpServletRequest request) throws Exception {
                    Boolean feedbackPageMessage = true ;                       
                    String text = "";
		    String email = request.getParameter("email") ;
		    String notificationReceipt = request.getParameter("notificationReceipt") ;
		    String notificationFollowup = request.getParameter("notificationFollowup") ;
		    
		    if ( email != null ) 
		    {
			    if (validate(email))
			    {	
				    Context.getUserService().setUserProperty(Context.getUserContext().getAuthenticatedUser(), "feedback_email", email) ;
				    feedbackPageMessage = true ;
			    }
			    else
			    {
				    feedbackPageMessage = false ;
			    }			    
		    }
		    if (notificationReceipt != null ) 
		    {
			Context.getUserService().setUserProperty(Context.getUserContext().getAuthenticatedUser(), "feedback_notificationReceipt", notificationReceipt) ;
		    }
		    if (notificationFollowup != null ) 
		    {
			Context.getUserService().setUserProperty(Context.getUserContext().getAuthenticatedUser(), "feedback_notificationFollowup", notificationFollowup) ;
			    
		    }                    		  
		    
		    log.debug("Returning hello world text: " + text);
		
		    return feedbackPageMessage ;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Object o = Context.getService(FeedbackService.class);
                FeedbackService service = (FeedbackService)o;
		String  feedback_email = Context.getAuthenticatedUser().getUserProperty("feedback_email") ;
		String  feedback_notificationReceipt = Context.getAuthenticatedUser().getUserProperty("feedback_notificationReceipt") ;
		String  feedback_notificationFollowup = Context.getAuthenticatedUser().getUserProperty("feedback_notificationFollowup") ;

		if (feedback_email != null)
		{
			map.put("feedback_email", feedback_email) ;
		}
		if (feedback_notificationReceipt != null)
		{
			map.put("feedback_notificationReceipt", feedback_notificationReceipt) ;
		}
		if (feedback_notificationFollowup != null)
		{
			map.put("feedback_notificationFollowup", feedback_notificationFollowup) ;
		}
		if ("false".equals(req.getParameter("feedbackMessage")) && !"".equals(req.getParameter("email")) ) 
		{
			map.put("feedbackPageMessage", "feedback.preference.email.incorrect") ;
		}
		else if ("true".equals(req.getParameter("feedbackMessage")))
		{
			map.put("feedbackPageMessage", "feedback.preference.email.added") ;
		}

		return map ;                         		
	}
	
}
