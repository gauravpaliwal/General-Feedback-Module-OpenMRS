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

import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.openmrs.module.feedback.PredefinedSubject;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest ;
import org.openmrs.api.context.Context;

import javax.servlet.http.HttpServletRequest;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class AddPredefinedSubjectFormControllerTest extends BaseModuleWebContextSensitiveTest {
	
    	private FeedbackService service;
	private FeedbackListController controller;
	private MockHttpServletRequest request;
	private HttpServletResponse response;
    
    public AddPredefinedSubjectFormControllerTest()   {
    }

    @BeforeClass
    public static void setUpClass() throws Exception { 	 	    
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
	/*executed before the test is run*/
	this.service = Context.getService(FeedbackService.class); 	
	this.controller = new FeedbackListController();
	this.request = new MockHttpServletRequest();
	this.response = new MockHttpServletResponse();
	/*this file is in the same folder of test resources where the hibernate mapping file is located*/
	initializeInMemoryDatabase() ;
	executeDataSet("PredefinedSubjectDataset.xml");
	/*Sample data is loaded into the system*/
	authenticate() ;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of formBackingObject method, of class AddPredefinedSubjectFormController.
     */
    @Test
    public void testFormBackingObject() throws Exception {
        System.out.println("formBackingObject");
	PredefinedSubject test = new PredefinedSubject() ;
	
	Assert.assertEquals("Test Sucessfull with dataset feedbackSeverityId : 3", service.getPredefinedSubject(3).getSubject() , "to_test_if_it_is_possible_to_enter_exactly_fifty_" ) ;
	
	System.out.println(service.getPredefinedSubject(3).getSubject()) ;
	
	System.out.println("holla");
                HttpServletRequest req = null;
		authenticate() ;
                AddPredefinedSubjectFormController instance = new AddPredefinedSubjectFormController();
                Boolean expResult = null;
                Boolean result = instance.formBackingObject(request);
                System.out.println("formBackingObject");
                ModelAndView mv = new ModelAndView();
                instance.setSuccessView("someValue") ;
                request.setSession(new MockHttpSession(null));
                request.setMethod("POST") ;
                request.addParameter("predefinedsubject", "Testing");
		
                mv = instance.handleRequest(request, response) ;
                FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
                System.out.println(hService.getPredefinedSubjects()) ;

                /*Boolean expResult = null;
                assertEquals(expResult, result);*/
    }

    /**
     * Test of referenceData method, of class AddPredefinedSubjectFormController.
     */
/*    @Test
    public void testReferenceData() throws Exception {
        System.out.println("referenceData");
        HttpServletRequest req = null;
        AddPredefinedSubjectFormController instance = new AddPredefinedSubjectFormController();
        Map expResult = null;
        Map result = instance.referenceData(req);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     * 
     */
}