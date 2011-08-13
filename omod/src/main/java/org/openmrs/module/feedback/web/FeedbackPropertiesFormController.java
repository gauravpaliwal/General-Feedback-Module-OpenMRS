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

import org.openmrs.GlobalProperty;
import org.openmrs.api.context.Context;
import org.openmrs.web.WebConstants;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.SimpleFormController;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class FeedbackPropertiesFormController extends SimpleFormController {
    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /** Logger for this class and subclasses */
    protected final Log log     = LogFactory.getLog(getClass());
    Pattern             pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher     matcher;

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }

    @Override
    protected String formBackingObject(HttpServletRequest request) throws Exception {
        String  text            = "";
        Boolean feedbackMessage = null;

        /* To make sure that the status is neither NULL nor empty */
        String feedbackNotification           = request.getParameter("feedbackNotification");
        String feedbackNotificationEmail      = request.getParameter("feedbackNotificationEmail");
        String feedbackAdminNotification      = request.getParameter("feedbackAdminNotification");
        String feedbackAdminNotificationEmail = request.getParameter("feedbackAdminNotificationEmail");
        String feedbackUiNotification         = request.getParameter("feedbackUiNotification");

        if (StringUtils.hasLength(feedbackNotification)) {
            GlobalProperty globalProperty = new GlobalProperty();

            globalProperty.setProperty("feedback.notification");
            globalProperty.setPropertyValue(feedbackNotification);
            Context.getAdministrationService().setGlobalProperty(globalProperty);
            feedbackMessage = true;
        }

        if (StringUtils.hasLength(feedbackAdminNotification)) {
            GlobalProperty globalProperty = new GlobalProperty();

            globalProperty.setProperty("feedback.admin.notification");
            globalProperty.setPropertyValue(feedbackAdminNotification);
            Context.getAdministrationService().setGlobalProperty(globalProperty);
            feedbackMessage = true;
        }

        if (StringUtils.hasLength(feedbackUiNotification)) {
            GlobalProperty globalProperty = new GlobalProperty();

            globalProperty.setProperty("feedback.ui.notification");
            globalProperty.setPropertyValue(feedbackUiNotification);
            Context.getAdministrationService().setGlobalProperty(globalProperty);
            feedbackMessage = true;
        }

        if (StringUtils.hasLength(feedbackNotificationEmail)) {
            if (validate(feedbackNotificationEmail)) {
                GlobalProperty globalProperty = new GlobalProperty();

                globalProperty.setProperty("feedback.notification.email");
                globalProperty.setPropertyValue(feedbackNotificationEmail);
                Context.getAdministrationService().setGlobalProperty(globalProperty);
                feedbackMessage = true;
            } else {
                request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.preference.email.incorrect");

                return text;
            }
        }

        if (StringUtils.hasLength(feedbackAdminNotificationEmail)) {
            if (validate(feedbackAdminNotificationEmail)) {
                GlobalProperty globalProperty = new GlobalProperty();

                globalProperty.setProperty("feedback.admin.notification.email");
                globalProperty.setPropertyValue(feedbackAdminNotificationEmail);
                Context.getAdministrationService().setGlobalProperty(globalProperty);
                feedbackMessage = true;
            } else {
                request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.preference.email.incorrect");

                return text;
            }
        }

        log.debug("Returning hello world text: " + text);

        if ((feedbackMessage != null) && (feedbackMessage == true)) {
            request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.preference.email.added");
        }

        return text;
    }

    @Override
    protected Map referenceData(HttpServletRequest req) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        return map;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
