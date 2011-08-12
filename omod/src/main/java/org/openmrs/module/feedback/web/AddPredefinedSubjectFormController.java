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
import org.openmrs.module.feedback.PredefinedSubject;
import org.openmrs.web.WebConstants;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.SimpleFormController;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class AddPredefinedSubjectFormController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

    @Override
    protected Boolean formBackingObject(HttpServletRequest request) throws Exception {
        Boolean feedbackMessage   = false;
        String  sortWeight        = request.getParameter("sortWeight");
        String  predefinedSubject = request.getParameter("predefinedsubject");

        /* The Subject can't be NULL or an empty string */
        if (StringUtils.hasLength(predefinedSubject)) {
            Object            o       = Context.getService(FeedbackService.class);
            FeedbackService   service = (FeedbackService) o;
            PredefinedSubject s       = new PredefinedSubject();

            if (!StringUtils.hasLength(sortWeight) || (sortWeight == null)) {
                s.setSortWeight(0);
                s.setSubject(predefinedSubject);
                service.savePredefinedSubject(s);

                /**
                 * Notifies to the Controller that the predefined subject has been successfully added
                 * with the help of get feedbackPageMessage param
                 */
                request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR,
                                                  "feedback.notification.predefinedSubject.added");
            } else if (isInt(sortWeight)) {
                s.setSortWeight(Integer.parseInt(sortWeight));
                s.setSubject(predefinedSubject);
                service.savePredefinedSubject(s);

                /**
                 * Notifies to the Controller that the predefined subject has been successfully added
                 * with the help of get feedbackPageMessage param
                 */
                request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR,
                                                  "feedback.notification.predefinedSubject.added");
            } else {
                request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.number.error");
            }

            /** This makes sure that the Predefined Subject value always remain less then or equal to 50 */
        }

        return feedbackMessage;
    }

    private Boolean isInt(String checkInt) throws Exception {
        try {
            Integer.parseInt(checkInt);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    protected Map referenceData(HttpServletRequest req) throws Exception {
        Map<String, Object> map      = new HashMap<String, Object>();
        FeedbackService     hService = (FeedbackService) Context.getService(FeedbackService.class);

        map.put("predefinedsubjects", hService.getPredefinedSubjects());

        return map;
    }
}

