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

import java.util.HashMap;
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

public class SubmitFeedbackControllerTest extends BaseModuleWebContextSensitiveTest {
		
	private FeedbackService service;
	private FeedbackAdminListController controller;
	private MockHttpServletRequest request;
	private HttpServletResponse response;
	private Boolean expResult = false ;
	private Boolean result = true ;
	
	public SubmitFeedbackControllerTest() {
	}
	
	@Before
	public void setUp() throws Exception {		
		
		/*executed before the test is run*/
		this.service = Context.getService(FeedbackService.class); 	
		this.controller = new FeedbackAdminListController();
		this.request = new MockHttpServletRequest();
		this.response = new MockHttpServletResponse();
		/*this file is in the same folder of test resources where the hibernate mapping file is located*/
		initializeInMemoryDatabase() ;
		executeDataSet("SeverityDataset.xml");
		executeDataSet("PredefinedSubjectDataset.xml");
		/*Sample data is loaded into the system*/
		authenticate() ;
		
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testpopulateModel() throws Exception {
		System.out.println("poplulateModel");
		SubmitFeedbackController instance = new SubmitFeedbackController();
		Map<String, Object> reqmap = new HashMap<String, Object>();
		instance.populateModel(request, reqmap)  ;
		/*to check wheather the data is sent or not binded into the key feedback*/
		if (!reqmap.containsKey("predefinedsubjects") || !reqmap.containsKey("severities"))
		{
			Assert.fail("Do not contain the object predefined subjects and severities") ;
		}
		
	}
}
	
	
	

