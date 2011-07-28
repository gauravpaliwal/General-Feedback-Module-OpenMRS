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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.Feedback ;
import org.openmrs.module.feedback.FeedbackService;

public class FileDownloadServlet extends HttpServlet {
	
	public static final long serialVersionUID = 1231231L;
	
	private Log log = LogFactory.getLog(getClass());
	
	// Content type mappings
	public static final String defaultContentType = "application/octet-stream";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
		try {   
                        if ( Context.getUserContext().getAuthenticatedUser().isSuperUser() ) 
                        { 
                            String feedbackId = request.getParameter("feedbackId")  ;
			    Object o = Context.getService(FeedbackService.class);
                            FeedbackService service = (FeedbackService)o ;    
                            Feedback feedback = service.getFeedback(Integer.parseInt(feedbackId)) ;
			    if (request.getParameter("feedbackId") != null && service.getFeedback(Integer.parseInt(feedbackId)) != null ) {
                            feedback = service.getFeedback(Integer.parseInt(feedbackId)) ;
                            byte[] attachment = feedback.getMessage() ;

                            // Keeping these same as these are for the versionedfilemodule. Modify response to disable caching
                            response.setHeader("Pragma", "No-cache");
                            response.setDateHeader("Expires", 0);
                            response.setHeader("Cache-Control", "no-cache");
                            response.setContentLength(attachment.length);
                            //response.setHeader("Content-Disposition", "attachment; filename=" + vf.getFullName().replace(" ", "_"));

                            // Determine content type for response
                            //String contentType = vf.getContentType() != null ? vf.getContentType() : defaultContentType;
                            response.setContentType("images");			
                            response.getOutputStream().write(feedback.getMessage());
			    }
                        }
                        
		}
		// Add error handling above and remove this try/catch 
		catch (Exception e) {
			log.error("unable to get file", e);
		}
	}
	
	/**
	 * 
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}