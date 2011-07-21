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

import org.openmrs.web.test.BaseModuleWebContextSensitiveTest;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.openmrs.test.BaseContextSensitiveTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletResponse;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackService ;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.openmrs.web.controller.person.PersonFormController;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;


public class AddFeedbackFormControllerTest extends BaseModuleWebContextSensitiveTest {
	

	
	
	@BeforeClass
	public void setUp() {
		// code that will be invoked before this test starts
	}
	
	@Test
	public void aTest() {
		System.out.println("Test");
	}
	
	@Test
	public void testFormBackingObject() throws Exception {
		System.out.println("formBackingObject");
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse(); ;
		ModelAndView mv = new ModelAndView();
		HttpServletRequest req = null;
		/*AddFeedbackFormController instance = new AddFeedbackFormController();	*/
		AddFeedbackFormController instance = new AddFeedbackFormController() ;
		instance.setSuccessView("someValue") ;
		request.setSession(new MockHttpSession(null));
		request.setMethod("POST") ; 
		request.addParameter("predefinedSubject", "Testing");
		mv = instance.handleRequest(request, response) ;
		
		Boolean result = instance.formBackingObject(request);
		System.out.println(instance.getFormView()) ;
		System.out.println(response.getContentAsString()) ;
		System.out.println(result) ;
		/*Boolean expResult = null;
		assertEquals(expResult, result);*/

	}

/*	@Test
	public void testReferenceData() throws Exception {
		System.out.println("referenceData");
		HttpServletRequest req = null;
		AddFeedbackFormController instance = new AddFeedbackFormController();
		Map expResult = null;
		Map result = instance.referenceData(req);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}
*/	
	@AfterClass
	public void cleanUp() {
		// code that will be invoked after this test ends
	}
}
