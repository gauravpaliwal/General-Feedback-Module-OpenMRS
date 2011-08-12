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
import org.openmrs.module.feedback.Severity;
import org.openmrs.web.WebConstants;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.mvc.SimpleFormController;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class AddSeverityFormController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

    @Override
    protected String formBackingObject(HttpServletRequest request) throws Exception {
        Boolean         feedbackMessage = false;
        String          sortWeight      = request.getParameter("sortWeight");
        String          text            = "Not used";
        String          severity        = request.getParameter("severity");
        Object          o               = Context.getService(FeedbackService.class);
        FeedbackService service         = (FeedbackService) o;
        Severity        s               = new Severity();

        /* This checks to make sure that severity can't be empty or NULL */
        if (StringUtils.hasLength(severity) && StringUtils.hasLength(sortWeight)) {
            if (isInt(sortWeight)) {
                s.setSortWeight(Integer.parseInt(sortWeight));
            } else {
                request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.number.error");

                return text;
            }

            /** This makes sure that the Severity value always remain less then or equal to 50 */
            s.setSeverity(severity);
            service.saveSeverity(s);

            /** Notifies to the Controller that the predefined subject has been successfully added with the help of getStatus */
            request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.severity.added");
        } else if (StringUtils.hasLength(severity) &&!StringUtils.hasLength(sortWeight)) {
            s.setSeverity(severity);
            service.saveSeverity(s);

            /** Notifies to the Controller that the predefined subject has been successfully added with the help of getStatus */
            request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.severity.added");
        }

        log.debug("Returning hello world text: " + text);

        return text;
    }

    @Override
    protected Map referenceData(HttpServletRequest req) throws Exception {
        Map<String, Object> map      = new HashMap<String, Object>();
        FeedbackService     hService = (FeedbackService) Context.getService(FeedbackService.class);

        /* To list all the severites on the add severity page */
        map.put("severities", hService.getSeverities());

        /* TO update the status that the severity has been successfully saved */
        if ((req.getParameter("feedbackPageMessage") != null)
                && ServletRequestUtils.getBooleanParameter(req, "feedbackPageMessage")) {
            map.put("feedbackPageMessage", "feedback.notification.severity.added");
        } else {
            map.put("feedbackPageMessage", "");
        }

        return map;
    }

    private Boolean isInt(String checkInt) throws Exception {
        try {
            Integer.parseInt(checkInt);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}

