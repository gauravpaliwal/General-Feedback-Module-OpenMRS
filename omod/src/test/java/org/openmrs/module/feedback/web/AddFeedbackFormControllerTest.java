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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import junit.framework.Assert;

import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpServletRequest;

import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.module.feedback.Severity ;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest ;
import org.openmrs.api.context.Context;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddFeedbackFormControllerTest extends BaseModuleWebContextSensitiveTest {
	
	private FeedbackService service;
	private FeedbackListController controller;
	private MockHttpServletRequest request;
	private HttpServletResponse response;
	private Boolean expResult = false ;
	private Boolean result = true ;
	
	public AddFeedbackFormControllerTest() {
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
		executeDataSet("FeedbackDataset.xml");
		/*Sample data is loaded into the system*/
		authenticate() ;
		
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of formBackingObject method, of class AddFeedbackFormController.
	 */
	@Test
	public void testFormBackingObject() throws Exception {
		System.out.println("formBackingObject");
		HttpServletRequest req = null;
		AddFeedbackFormController instance = new AddFeedbackFormController();
		/*No testing now as their are a number of the Extra Credit dtuff that will effect these test cases*/
	}

	/**
	 * Test of referenceData method, of class AddFeedbackFormController.
	 */
	@Test
	public void testReferenceData() throws Exception {
		System.out.println("referenceData");
		HttpServletRequest req = null;
		AddFeedbackFormController instance = new AddFeedbackFormController();
		/*No testing now as their are a number of the Extra Credit dtuff that will effect these test cases*/
	}
}
