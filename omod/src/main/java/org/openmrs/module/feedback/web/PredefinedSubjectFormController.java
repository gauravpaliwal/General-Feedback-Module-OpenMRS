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

public class PredefinedSubjectFormController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

    @Override
    protected String formBackingObject(HttpServletRequest request) throws Exception {
        Boolean         feedbackMessage     = false;
        Object          o                   = Context.getService(FeedbackService.class);
        FeedbackService service             = (FeedbackService) o;
        String          text                = "";
        String          predefinedsubjectid = request.getParameter("predefinedsubjectid");
        String          sortWeight          = request.getParameter("sortWeight");
        String          predefinedSubject   = request.getParameter("predefinedsubject");

        if (!StringUtils.hasLength(predefinedsubjectid)
                || (service.getPredefinedSubject(Integer.parseInt(predefinedsubjectid)) == null)) {

            /* Just log this for the statistics */
            request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR,
                                              "feedback.notification.predefinedSubject.deleted");
        } else if ((predefinedsubjectid != null) && "1".equals(request.getParameter("delete"))) {

            /* delete the element */
            PredefinedSubject s = new PredefinedSubject();

            s = service.getPredefinedSubject(Integer.parseInt(predefinedsubjectid));
            service.deletePredefinedSubject(s);
            text = predefinedsubjectid;
        } else if ((predefinedsubjectid != null) && "1".equals(request.getParameter("save"))) {

            /* save the element */
            PredefinedSubject s = service.getPredefinedSubject(Integer.parseInt(predefinedsubjectid));

            /** This makes sure that the Predefined Subject value always remain less then or equal to 50 */
            s.setSubject(request.getParameter("predefinedsubject"));

            if (isInt(sortWeight)) {
                s.setSortWeight(Integer.parseInt(sortWeight));
            }

            /* Service Method to save the data */
            service.savePredefinedSubject(s);
            request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR,
                                              "feedback.notification.predefinedSubject.saved");
            text = predefinedsubjectid;
        }

        log.debug("Returning hello world text: " + text);

        return text;
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
        Map<String, Object> map                 = new HashMap<String, Object>();
        Object              o                   = Context.getService(FeedbackService.class);
        FeedbackService     service             = (FeedbackService) o;
        FeedbackService     hService            = (FeedbackService) Context.getService(FeedbackService.class);
        String              predefinedsubjectid = req.getParameter("predefinedsubjectid");

        /* Predefined Subject is deleted incase the subject with predefinedID is not found */
        if (!StringUtils.hasLength(predefinedsubjectid)
                || (service.getPredefinedSubject(Integer.parseInt(predefinedsubjectid)) == null)) {
            PredefinedSubject s = new PredefinedSubject();

            map.put("predefinedsubjects", s);

            return map;
        }

        /* Otherwise give the data about the predefined subject */
        else {
            PredefinedSubject s = service.getPredefinedSubject(Integer.parseInt(predefinedsubjectid));

            map.put("predefinedsubjects", s);

            return map;
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
