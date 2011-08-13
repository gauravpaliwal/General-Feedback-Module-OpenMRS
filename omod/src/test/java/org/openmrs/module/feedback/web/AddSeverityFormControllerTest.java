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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.module.feedback.Severity;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

//~--- JDK imports ------------------------------------------------------------

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSeverityFormControllerTest extends BaseModuleWebContextSensitiveTest {
    private Boolean                     expResult = false;
    private Boolean                     result    = true;
    private FeedbackAdminListController controller;
    private MockHttpServletRequest      request;
    private HttpServletResponse         response;
    private FeedbackService             service;

    public AddSeverityFormControllerTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {}

    @AfterClass
    public static void tearDownClass() throws Exception {}

    @Before
    public void setUp() throws Exception {

        /* executed before the test is run */
        this.service    = Context.getService(FeedbackService.class);
        this.controller = new FeedbackAdminListController();
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
     * Test of formBackingObject method, of class AddSeverityFormController.
     */
    @Test
    public void testFormBackingObject() throws Exception {
        System.out.println("formBackingObject");

        HttpServletRequest req = null;

        authenticate();

        AddSeverityFormController instance = new AddSeverityFormController();

        /* To execute the test case where the severity level is < 50 */
        this.request = new MockHttpServletRequest();

        ModelAndView mv = new ModelAndView();

        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.addParameter("severity", "Testing");
        mv = instance.handleRequest(request, response);

        List severities = service.getSeverities();

        for (Iterator it = severities.iterator(); it.hasNext(); ) {
            Severity s = (Severity) it.next();

            if ("Testing".equals(s.getSeverity())) {
                this.expResult = true;
            }
        }

        Assert.assertEquals(this.expResult, this.result);

        /* To execute the test case where the severity level is = 50 */
        this.request = new MockHttpServletRequest();
        mv           = new ModelAndView();
        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.addParameter("severity", "estingTestingTestingTestingTestingTestingTestingTe");
        mv         = instance.handleRequest(request, response);
        severities = service.getSeverities();

        for (Iterator it = severities.iterator(); it.hasNext(); ) {
            Severity s = (Severity) it.next();

            if ("estingTestingTestingTestingTestingTestingTestingTe".equals(s.getSeverity())) {
                this.expResult = true;
            }
        }

        Assert.assertEquals(this.expResult, this.result);

        /* To execute the test case where the severity level is > 50 */
        this.request = new MockHttpServletRequest();
        mv           = new ModelAndView();
        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.addParameter("severity",
                             "TestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTesting");
        mv         = instance.handleRequest(request, response);
        severities = service.getSeverities();

        for (Iterator it = severities.iterator(); it.hasNext(); ) {
            Severity s = (Severity) it.next();

            if ("TestingTestingTestingTestingTestingTestingTestingT".equals(s.getSeverity())) {
                this.expResult = true;
            }
        }

        Assert.assertEquals(this.expResult, this.result);

        /* To execute the test case where the severity level is = 0 */
        this.request = new MockHttpServletRequest();
        mv           = new ModelAndView();
        instance.setSuccessView("someValue");
        expResult = true;
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.addParameter("severity", "");
        mv         = instance.handleRequest(request, response);
        severities = service.getSeverities();

        for (Iterator it = severities.iterator(); it.hasNext(); ) {
            Severity s = (Severity) it.next();

            if ("".equals(s.getSeverity())) {
                this.expResult = false;
            }
        }

        Assert.assertEquals(this.expResult, this.result);
    }

    /**
     * No need to test as this functionality is already tested in the formBackingObject
     * Test of referenceData method, of class AddSeverityFormController.
     *
     * @Test
     * public void testReferenceData() throws Exception {
     *       System.out.println("referenceData");
     *       HttpServletRequest req = null;
     *       AddSeverityFormController instance = new AddSeverityFormController();
     *       Map expResult = null;
     *       Map result = instance.referenceData(req);
     *       Assert.assertEquals(expResult, result);
     *       // TODO review the generated test code and remove the default call to fail.
     *       Assert.fail("The test case is a prototype.");
     * }
     *
     *
     */
}


//~ Formatted by Jindent --- http://www.jindent.com
