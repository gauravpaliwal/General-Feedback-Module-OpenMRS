/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.feedback.web;



import org.openmrs.web.test.BaseModuleWebContextSensitiveTest;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletResponse;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackService ;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;


public class AddPredefinedSubjectFormControllerTest  extends BaseModuleWebContextSensitiveTest {
	
	@BeforeClass
	public void setUp() throws Exception {

		
		// code that will be invoked before this test starts
	}
	
	@Test
	public void testFormBackingObject() throws Exception {
		System.out.println("holla");
		HttpServletRequest req = null;
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse(); 
		AddPredefinedSubjectFormController instance = new AddPredefinedSubjectFormController();
		initializeInMemoryDatabase();
		authenticate() ;
		Boolean expResult = null;
		Boolean result = instance.formBackingObject(request);
		System.out.println("formBackingObject");
		ModelAndView mv = new ModelAndView();
		instance.setSuccessView("someValue") ;
		request.setSession(new MockHttpSession(null));
		request.setMethod("POST") ; 
		request.addParameter("predefinedSubject", "Testing");
		mv = instance.handleRequest(request, response) ;
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
		System.out.println(hService.getPredefinedSubjects()) ;
		System.out.println(instance.getFormView()) ;
		System.out.println(response.getContentAsString()) ;
		System.out.println(result) ;
		/*Boolean expResult = null;
		assertEquals(expResult, result);*/
	}

	
	@AfterClass
	public void cleanUp() {
		// code that will be invoked after this test ends
	}

	/**
	 * Test of formBackingObject method, of class AddPredefinedSubjectFormController.
	 */
	
	/**
	 * Test of referenceData method, of class AddPredefinedSubjectFormController.
	 */
	@org.junit.Test
	public void testReferenceData() throws Exception {
		System.out.println("referenceData");
		HttpServletRequest req = null;
		AddPredefinedSubjectFormController instance = new AddPredefinedSubjectFormController();
		Map expResult = null;
		Map result = instance.referenceData(req);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}
}
