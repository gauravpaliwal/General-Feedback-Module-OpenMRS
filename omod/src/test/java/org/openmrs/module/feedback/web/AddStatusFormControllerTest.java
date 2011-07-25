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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import junit.framework.Assert;

import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpServletRequest;

import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest ;
import org.openmrs.api.context.Context;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openmrs.module.feedback.Status;

public class AddStatusFormControllerTest extends BaseModuleWebContextSensitiveTest {
	
	private FeedbackService service;
	private FeedbackListController controller;
	private MockHttpServletRequest request;
	private HttpServletResponse response;
	private Boolean expResult = false ;
	private Boolean result = true ;
	
	public AddStatusFormControllerTest() {
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
		executeDataSet("StatusDataset.xml");
		/*Sample data is loaded into the system*/
		authenticate() ;
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of formBackingObject method, of class AddStatusFormController.
	 */
	@Test
	public void testFormBackingObject() throws Exception {
		System.out.println("formBackingObject");
		HttpServletRequest req = null;
		AddStatusFormController instance = new AddStatusFormController();

		/*To execute the test case where the status is < 50*/
		this.request = new MockHttpServletRequest();
		ModelAndView mv = new ModelAndView();
		instance.setSuccessView("someValue") ;
		request.setSession(new MockHttpSession(null));
		request.setMethod("POST") ;
		request.addParameter("status", "Testing");		
		mv = instance.handleRequest(request, response) ;
		List statuses = service.getStatuses() ;
		for (Iterator it = statuses.iterator(); it.hasNext ();) 
		{
			Status s = (Status)it.next (); 
			if ("Testing".equals(s.getStatus()))
			{
				this.expResult= true ;
			}
		}
		Assert.assertEquals(this.expResult, this.result)  ;
		
		/*To execute the test case where the status is = 50*/
		this.request = new MockHttpServletRequest();
		mv = new ModelAndView();
		instance.setSuccessView("someValue") ;
		request.setSession(new MockHttpSession(null));
		request.setMethod("POST") ;
		request.addParameter("status", "estingTestingTestingTestingTestingTestingTestingTe");		
		mv = instance.handleRequest(request, response) ;
		statuses = service.getStatuses() ;
		for (Iterator it = statuses.iterator(); it.hasNext ();) 
		{
			Status s = (Status)it.next (); 
			if ("estingTestingTestingTestingTestingTestingTestingTe".equals(s.getStatus()))
			{
				this.expResult= true ;
			}
		}
		Assert.assertEquals(this.expResult, this.result)  ;
		
		/*To execute the test case where the status is > 50*/
		this.request = new MockHttpServletRequest();
		mv = new ModelAndView();
		instance.setSuccessView("someValue") ;
		request.setSession(new MockHttpSession(null));
		request.setMethod("POST") ;
		request.addParameter("status", "TestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTesting");		
		mv = instance.handleRequest(request, response) ;
		statuses = service.getStatuses() ;
		for (Iterator it = statuses.iterator(); it.hasNext ();) 
		{
			Status s = (Status)it.next (); 
			if ("TestingTestingTestingTestingTestingTestingTestingT".equals(s.getStatus()))
			{
				this.expResult= true ;
			}
		}
		Assert.assertEquals(this.expResult, this.result)  ;
		
		/*To execute the test case where the status is = 0 */
		this.request = new MockHttpServletRequest();
		this.expResult= true ;
		mv = new ModelAndView();
		instance.setSuccessView("someValue") ;
		request.setSession(new MockHttpSession(null));
		request.setMethod("POST") ;
		request.addParameter("status", "");		
		mv = instance.handleRequest(request, response) ;
		statuses = service.getStatuses() ;
		for (Iterator it = statuses.iterator(); it.hasNext ();) 
		{
			Status s = (Status)it.next (); 
			if ("".equals(s.getStatus()))
			{
				this.expResult= false ;
			}
		}
		Assert.assertEquals(this.expResult, this.result)  ;
	}

	/**
	 * No need to test as these functionality tests are already included in the above formBackingObject
	 * Test of referenceData method, of class AddStatusFormController.
	 
	@Test
	public void testReferenceData() throws Exception {
		System.out.println("referenceData");
		HttpServletRequest req = null;
		AddStatusFormController instance = new AddStatusFormController();
		Map expResult = null;
		Map result = instance.referenceData(req);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		Assert.fail("The test case is a prototype.");
	}
	 * 
	 * 
	 */
}
