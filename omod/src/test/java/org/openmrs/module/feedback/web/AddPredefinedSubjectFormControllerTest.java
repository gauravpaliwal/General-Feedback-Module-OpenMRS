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
import org.openmrs.module.feedback.PredefinedSubject;
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

public class AddPredefinedSubjectFormControllerTest extends BaseModuleWebContextSensitiveTest {
    private Boolean                     expResult = false;
    private Boolean                     result    = true;
    private FeedbackAdminListController controller;
    private MockHttpServletRequest      request;
    private HttpServletResponse         response;
    private FeedbackService             service;

    public AddPredefinedSubjectFormControllerTest() {}

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
        executeDataSet("PredefinedSubjectDataset.xml");

        /* Sample data is loaded into the system */
        authenticate();
    }

    @After
    public void tearDown() {}

    /**
     * Test of formBackingObject method, of class AddPredefinedSubjectFormController.
     */
    @Test
    public void testFormBackingObject() throws Exception {
        HttpServletRequest req = null;

        authenticate();

        AddPredefinedSubjectFormController instance = new AddPredefinedSubjectFormController();

        System.out.println("formBackingObject");

        /* To execute the test case where the predefinedsubject is < 50 */
        this.request = new MockHttpServletRequest();

        ModelAndView mv = new ModelAndView();

        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.addParameter("predefinedsubject", "Testing");
        mv = instance.handleRequest(request, response);

        List predefinedSubjects = service.getPredefinedSubjects();

        for (Iterator it = predefinedSubjects.iterator(); it.hasNext(); ) {
            PredefinedSubject s = (PredefinedSubject) it.next();

            if ("Testing".equals(s.getSubject())) {
                this.expResult = true;
            }
        }

        Assert.assertEquals(this.expResult, this.result);

        /* To execute the test case where the predefinedsubject is > 50 */
        this.request   = new MockHttpServletRequest();
        this.expResult = false;
        mv             = new ModelAndView();
        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.addParameter("predefinedsubject", "TestingTestingTestingTestingTestingTestingTestingTestingTesting");
        mv                 = instance.handleRequest(request, response);
        predefinedSubjects = service.getPredefinedSubjects();

        for (Iterator it = predefinedSubjects.iterator(); it.hasNext(); ) {
            PredefinedSubject s = (PredefinedSubject) it.next();

            if ("TestingTestingTestingTestingTestingTestingTestingT".equals(s.getSubject())) {
                this.expResult = true;
            }
        }

        Assert.assertEquals(this.expResult, this.result);

        /* To execute the test case where the predefinedsubject is = 50 */
        this.request   = new MockHttpServletRequest();
        this.expResult = false;
        mv             = new ModelAndView();
        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.addParameter("predefinedsubject", "estingTestingTestingTestingTestingTestingTestingTe");
        mv                 = instance.handleRequest(request, response);
        predefinedSubjects = service.getPredefinedSubjects();

        for (Iterator it = predefinedSubjects.iterator(); it.hasNext(); ) {
            PredefinedSubject s = (PredefinedSubject) it.next();

            if ("estingTestingTestingTestingTestingTestingTestingTe".equals(s.getSubject())) {
                this.expResult = true;
            }
        }

        Assert.assertEquals(this.expResult, this.result);

        /* To execute the test case where the predefinedsubject is = 0 */
        this.request   = new MockHttpServletRequest();
        this.expResult = true;
        mv             = new ModelAndView();
        instance.setSuccessView("someValue");
        request.setSession(new MockHttpSession(null));
        request.setMethod("POST");
        request.addParameter("predefinedsubject", "");
        mv                 = instance.handleRequest(request, response);
        predefinedSubjects = service.getPredefinedSubjects();

        for (Iterator it = predefinedSubjects.iterator(); it.hasNext(); ) {
            PredefinedSubject s = (PredefinedSubject) it.next();

            if ("".equals(s.getSubject())) {
                this.expResult = false;
            }
        }

        Assert.assertEquals(this.expResult, this.result);
    }

    /*
     * Not required to test as it also the same set of function already tested in the formBackingObject method.
     * Test of referenceData method, of class AddPredefinedSubjectFormController.
     *
     * @Test
     * public void testReferenceData() throws Exception {
     *   System.out.println("referenceData");
     *   HttpServletRequest req = null;
     *   AddPredefinedSubjectFormController instance = new AddPredefinedSubjectFormController();
     *   Map expResult = null;
     *   Map result = instance.referenceData(req);
     *   // TODO review the generated test code and remove the default call to fail.
     *   fail("The test case is a prototype.");
     * }
     *
     */
}


//~ Formatted by Jindent --- http://www.jindent.com
