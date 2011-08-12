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

//~--- non-JDK imports --------------------------------------------------------

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.Feedback;
import org.openmrs.module.feedback.FeedbackComment;
import org.openmrs.module.feedback.FeedbackService;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadServlet extends HttpServlet {

    // Content type mappings
    public static final String defaultContentType = "application/octet-stream";
    public static final long   serialVersionUID   = 1231231L;
    private Log                log                = LogFactory.getLog(getClass());
    Object                     o                  = Context.getService(FeedbackService.class);
    FeedbackService            service            = (FeedbackService) o;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (Context.getAuthenticatedUser().isSuperUser() || Context.hasPrivilege("Admin Feedback")
                    || Context.hasPrivilege("Add Feedback")) {
                String   feedbackId = request.getParameter("feedbackId");
                Feedback feedback;

                feedback = new Feedback();

                User u = Context.getUserContext().getAuthenticatedUser();

                try {
                    feedback = service.getFeedback(Integer.parseInt(feedbackId));
                } catch (Exception e) {
                    log.error(e);
                }

                if (!"".equals(request.getParameter("feedbackId")) && (request.getParameter("feedbackId") != null)
                        && (service.getFeedback(Integer.parseInt(feedbackId)) != null)
                        && (u.isSuperUser() || Context.hasPrivilege("Admin Feedback")
                            || u.getUserId().equals(feedback.getCreator().getUserId()))) {
                    feedback = service.getFeedback(Integer.parseInt(feedbackId));
                    feedback = service.getFeedback(Integer.parseInt(feedbackId));

                    byte[] attachment = feedback.getMessage();

                    // Keeping these same as these are for the versionedfilemodule. Modify response to disable caching
                    response.setHeader("Pragma", "No-cache");
                    response.setDateHeader("Expires", 0);
                    response.setHeader("Cache-Control", "no-cache");
                    response.setContentLength(attachment.length);

                    // response.setHeader("Content-Disposition", "attachment; filename=" + vf.getFullName().replace(" ", "_"));

                    // Determine content type for response
                    // String contentType = vf.getContentType() != null ? vf.getContentType() : defaultContentType;
                    response.setContentType("images");
                    response.getOutputStream().write(feedback.getMessage());
                } else if (!"".equals(request.getParameter("feedbackCommentId"))
                           && (request.getParameter("feedbackCommentId") != null)
                           && (service.getFeedbackComment(Integer.parseInt(request.getParameter("feedbackCommentId")))
                               != null)) {
                    FeedbackComment feedbackComment =
                        service.getFeedbackComment(Integer.parseInt(request.getParameter("feedbackCommentId")));
                    byte[] attachment = feedbackComment.getAttachment();

                    // Keeping these same as these are for the versionedfilemodule. Modify response to disable caching
                    response.setHeader("Pragma", "No-cache");
                    response.setDateHeader("Expires", 0);
                    response.setHeader("Cache-Control", "no-cache");
                    response.setContentLength(attachment.length);

                    // response.setHeader("Content-Disposition", "attachment; filename=" + vf.getFullName().replace(" ", "_"));

                    // Determine content type for response
                    // String contentType = vf.getContentType() != null ? vf.getContentType() : defaultContentType;
                    response.setContentType("images");
                    response.getOutputStream().write(feedbackComment.getAttachment());
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


