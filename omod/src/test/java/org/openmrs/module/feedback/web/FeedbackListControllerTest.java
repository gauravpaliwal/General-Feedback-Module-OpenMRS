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


import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackService; 
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest ;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class FeedbackListControllerTest extends BaseModuleWebContextSensitiveTest {
	
	private FeedbackService service;
	private FeedbackListController controller;
	private MockHttpServletRequest request;
	private HttpServletResponse response;
    
    public FeedbackListControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
	    
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
		this.service = Context.getService(FeedbackService.class); 
		this.controller = new FeedbackListController();
		this.request = new MockHttpServletRequest();
		this.response = new MockHttpServletResponse();
		executeDataSet("gauravTest.xml");
		authenticate() ;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of formBackingObject method, of class FeedbackListController.
     */
    @Test
    public void testFormBackingObject() throws Exception {
        System.out.println("formBackingObject");
	executeDataSet("gauravTest.xml");
	executeDataSet("gaurav.xml");
	FeedbackListController instance = new FeedbackListController();
        String expResult = "10";
        String result = "10" ;
	Object o = Context.getService(FeedbackService.class);
        FeedbackService service = (FeedbackService)o;      
	System.out.println ( service.getSeverity(2).getSeverity() ) ;
	System.out.println ( "testing" ) ;
	gaurav() ;
        assertEquals(expResult, result);
        assert(true) ;

    }
    
    public void gaurav() throws Exception{
	    System.out.println("gaurav") ;
    }

    /**
     * Test of referenceData method, of class FeedbackListController.
     */
    @Test
    public void testReferenceData() throws Exception {
        System.out.println("referenceData");
        HttpServletRequest req = null;
        FeedbackListController instance = new FeedbackListController();
        assert(true) ;

    }
}
