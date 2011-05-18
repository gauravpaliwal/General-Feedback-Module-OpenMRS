package org.openmrs.module.feedback.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.HelloWorldResponse;
import org.openmrs.module.feedback.FeedbackService;

public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1239820102033L;
	private Log log = LogFactory.getLog(this.getClass());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doGet");
		PrintWriter writer = response.getWriter();
		writer.print("Hello World (from Servlet doGet)<br/>");
		
		try {
			Object o = Context.getService(FeedbackService.class);
			log.debug("Got service object: " + o);
			FeedbackService service = (FeedbackService)o;
			for (HelloWorldResponse r : service.getResponses())
				writer.print("Response: " + r.toString() + "\n");
			
			HelloWorldResponse r = new HelloWorldResponse();
			r.setResponse("Hello");
			r.setRetired(false);
			
			service.updateHelloWorldResponse(r);
			writer.print("After saving response");
		}
		catch (APIException apiexception) {
			apiexception.printStackTrace(writer);
		}	
		
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doPost");
		response.getWriter().print("Hello World (from Servlet doPost)");
	}

}
