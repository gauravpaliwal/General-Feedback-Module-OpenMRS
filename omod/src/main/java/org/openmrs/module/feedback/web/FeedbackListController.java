package org.openmrs.module.feedback.web;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.FeedbackFeedback;
import org.openmrs.module.feedback.FeedbackService;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class FeedbackListController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
		
                			
		String text = "Not used";
		
		log.debug("Returning hello world text: " + text);
		
		return text;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
		map.put("feedbacks", hService.getFeedbacks() ) ;
                return map;
		
	}
	
}
