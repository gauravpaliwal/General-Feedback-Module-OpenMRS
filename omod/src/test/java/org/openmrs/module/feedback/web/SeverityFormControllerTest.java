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

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

//~--- JDK imports ------------------------------------------------------------

import java.lang.String;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SeverityFormControllerTest extends BaseModuleWebContextSensitiveTest {
    private Boolean                expResult = true;
    private Boolean                result    = false;
    private SeverityFormController controller;
    private MockHttpServletRequest request;
    private HttpServletResponse    response;
    private FeedbackService        service;

    public SeverityFormControllerTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Before
    public void setUp() throws Exception {

        /* executed before the test is run */
        this.service    = Context.getService(FeedbackService.class);
        this.controller = new SeverityFormController();
        this.request    = new MockHttpServletRequest();
        this.response   = new MockHttpServletResponse();

        /* this file is in the same folder of test resources where the hibernate mapping file is located */
        initializeInMemoryDatabase();
        executeDataSet("SeverityDataset.xml");

        /* Sample data is loaded into the system */
        authenticate();
    }

    @After
    public void tearDown() {}

    /**
     * Test of formBackingObject method, of class SeverityFormController.
     */
    @Test
    public void testFormBackingObject() throws Exception {
        System.out.println("formBackingObject");

        HttpServletRequest     req      = null;
        SeverityFormController instance = new SeverityFormController();

        authenticate();

        /* To check wheather the delete works or not */
        this.request = new MockHttpServletRequest();

        ModelAndView mv = new ModelAndView();

        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.setParameter("feedbackSeverityId", "1");
        request.setParameter("delete", "1");
        mv = instance.handleRequest(request, response);

        if (service.getSeverity(1) == null) {
            result = true;
            Assert.assertEquals(expResult, result);
        } else {
            result = false;
            Assert.assertEquals(expResult, result);
        }

        /* To check wheather the delete works or not with wrong delete parameter value */
        this.request = new MockHttpServletRequest();
        mv           = new ModelAndView();
        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.setParameter("feedbackSeverityId", "2");
        request.setParameter("delete", "0");
        mv = instance.handleRequest(request, response);

        if (service.getSeverity(2) == null) {
            result = false;
            Assert.assertEquals(expResult, result);
        } else {
            result = true;
            Assert.assertEquals(expResult, result);
        }

        /* To check wheather the save works or not */
        this.request = new MockHttpServletRequest();
        mv           = new ModelAndView();
        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.setParameter("feedbackSeverityId", "2");
        request.setParameter("save", "1");
        request.setParameter("severity", "Testing");
        mv = instance.handleRequest(request, response);

        if ("Testing".equals(service.getSeverity(2).getSeverity())) {
            result = true;
            Assert.assertEquals(expResult, result);
        } else {
            result = false;
            Assert.assertEquals(expResult, result);
        }

        /* To check wheather the delete works or not with wrong save parameter value */
        this.request = new MockHttpServletRequest();
        mv           = new ModelAndView();
        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.setParameter("feedbackSeverityId", "3");
        request.setParameter("save", "0");
        request.setParameter("severity", "Testing");
        mv = instance.handleRequest(request, response);

        if ("Testing".equals(service.getSeverity(3).getSeverity())) {
            result = false;
            Assert.assertEquals(expResult, result);
        } else {
            result = true;
            Assert.assertEquals(expResult, result);
        }
    }

    /**
     * Nothing to test as no database write/edit database operation is done here only the message is shown based on the feedbackSeverityid submitted
     * Test of referenceData method, of class SeverityFormController.
     *
     * @Test
     * public void testReferenceData() throws Exception {
     *       System.out.println("referenceData");
     *       HttpServletRequest req = null;
     *       SeverityFormController instance = new SeverityFormController();
     *       Assert.assertEquals(expResult, result);
     *       // TODO review the generated test code and remove the default call to fail.
     *       Assert.fail("The test case is a prototype.");
     * }
     */
}


