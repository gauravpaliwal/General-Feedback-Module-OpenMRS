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

import org.springframework.web.servlet.mvc.SimpleFormController;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class FeedbackUserListController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

    /* Not in use */
    @Override
    protected String formBackingObject(HttpServletRequest request) throws Exception {
        String text = "Not used";

        log.debug("Returning hello world text: " + text);

        return text;
    }

    @Override
    protected Map referenceData(HttpServletRequest req) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        /* It sends the list of all the feedback submitted till now */
        FeedbackService hService = (FeedbackService) Context.getService(FeedbackService.class);

        map.put("feedbacks", hService.getFeedbacks(Context.getUserContext().getAuthenticatedUser()));

        return map;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
