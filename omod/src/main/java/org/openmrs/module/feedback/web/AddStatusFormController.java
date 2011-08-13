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

import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.module.feedback.Status;
import org.openmrs.web.WebConstants;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.mvc.SimpleFormController;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class AddStatusFormController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

    @Override
    protected String formBackingObject(HttpServletRequest request) throws Exception {
        String  text            = "Not Used";
        Boolean feedbackMessage = false;
        String  status          = request.getParameter("status");

        /* To make sure that the status is neither NULL nor empty */
        if ((status != null) && StringUtils.hasLength(status)) {
            Object          o       = Context.getService(FeedbackService.class);
            FeedbackService service = (FeedbackService) o;
            Status          x       = new Status();

            /** This makes sure that the status value always remain less then or equal to 50 */
            x.setStatus(status);
            service.saveStatus(x);
            request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.status.added");
        }

        log.debug("Returning hello world text: " + text);

        return text;
    }

    @Override
    protected Map referenceData(HttpServletRequest req) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        /* Return the list of all the saved statuses that will be diaplayed on the Add Status page */
        FeedbackService hService = (FeedbackService) Context.getService(FeedbackService.class);

        map.put("statuses", hService.getStatuses());

        return map;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
