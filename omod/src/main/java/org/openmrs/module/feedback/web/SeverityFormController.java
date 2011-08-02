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
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class SeverityFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
            
                    String text = "";
                    Object o = Context.getService(FeedbackService.class);
                    FeedbackService service = (FeedbackService)o;  
                    String SeverityId = request.getParameter("feedbackSeverityId") ;
		    String sortWeight = request.getParameter("sortWeight") ;

                    
                    if ( !StringUtils.hasLength(SeverityId) || service.getSeverity(Integer.parseInt(SeverityId)) == null )
                        {   /*Just for statistics that the elemented is deleted already or do not exists*/
                            System.out.println ("Nothing to do elemented already deleted") ;                    
                        } 
                    /*This is to tell that the item will be deleted incase delete is submitted*/
                    else if (SeverityId != null && "1".equals(request.getParameter("delete")) )
                        {                       
                            Severity s = service.getSeverity(Integer.parseInt(SeverityId)) ;
                            service.deleteSeverity( s );
                            text = SeverityId ;
                        }
                    /*save the severity*/
                    else if (SeverityId != null && "1".equals(request.getParameter("save")) )
                        {
                        
                            Severity s = service.getSeverity(Integer.parseInt(SeverityId)) ;			 
                        
                            /** This makes sure that the Severity value always remain less then or equal to 50*/
                            s.setSeverity(request.getParameter("severity") ) ;
			    
			     if (isInt(sortWeight))
				{
					s.setSortWeight(Integer.parseInt(sortWeight));
				}
                            text = "saved";
                                                     
                            service.saveSeverity(s) ;
                            text = SeverityId ;

                        }
                
                         		
		log.debug("Returning hello world text: " + text);
		
		return text;
		
	}
	
	private Boolean isInt (String checkInt) throws Exception
	{	
		try
		{
			Integer.parseInt(checkInt) ;
		}
		catch(Exception e) 
		{
			return false ;
		}			
		return true;
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Object o = Context.getService(FeedbackService.class);
                FeedbackService service = (FeedbackService)o;    
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
                String SeverityId = req.getParameter("feedbackSeverityId") ;
                
                /*To display the message that the severity has been deleted*/
                if ( !StringUtils.hasLength(SeverityId) ||  service.getSeverity(Integer.parseInt(SeverityId)) == null )
                {
                    Severity s = new Severity() ;
                    map.put("SeverityId" , s ) ;
                    map.put("feedbackPageMessage" , "feedback.notification.severity.deleted") ;
                    return map ;
                }
                else
                {
                    /*Return the severity with the specific feedbackID*/             
                    Severity s =  service.getSeverity(Integer.parseInt(SeverityId)) ;
                    map.put("severity" , s ) ;
                    map.put("feedbackPageMessage" , "") ;
                    return map ;
                }

		
	}
	
}
