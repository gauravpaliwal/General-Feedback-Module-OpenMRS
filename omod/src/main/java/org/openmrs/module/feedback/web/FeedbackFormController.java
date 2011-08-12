package org.openmrs.module.feedback.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.Feedback;
import org.openmrs.module.feedback.FeedbackComment;
import org.openmrs.module.feedback.FeedbackService;
import org.openmrs.web.WebConstants;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class FeedbackFormController extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

	@Override
	protected String formBackingObject(HttpServletRequest request) throws Exception {
		/* Make sure that neither the comment is empty or Null*/
		
		Object o = Context.getService(FeedbackService.class);
                FeedbackService service = (FeedbackService)o;
		String status = request.getParameter("status") ;
		String comment = request.getParameter("comment") ;
		Map<String, Object> map = new HashMap<String, Object>();

		if (!"".equals(status) && status != null )
		{
			try
				{	Feedback s = service.getFeedback((Integer.parseInt (request.getParameter("feedbackId") ))) ;
					s.setStatus( status );	
					service.saveFeedback(s) ;
				}
			catch(Exception e)
				{
					log.error(e);
				}
		}
    
                if (!"".equals(comment) && comment != null )
                {                       
                    try
		    {   Feedback s = service.getFeedback((Integer.parseInt (request.getParameter("feedbackId" ) ))) ;
			s.setComment( request.getParameter("comment"));		    
			service.saveFeedback( s );
			FeedbackComment k = new FeedbackComment() ;
			k.setComment(request.getParameter("comment"));
			String feedbackId = request.getParameter("feedbackId")  ;
			k.setFeedbackId(Integer.parseInt(feedbackId) ) ;
			if (request instanceof MultipartHttpServletRequest) 
                    {
                        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                        MultipartFile file = (MultipartFile) multipartRequest.getFile("file");
                        
                        if ( !file.isEmpty() )
                        {
                            if (file.getSize() <= 5242880 )
                            {
                                if (file.getOriginalFilename().endsWith(".jpeg")||file.getOriginalFilename().endsWith(".jpg")|| file.getOriginalFilename().endsWith(".gif")|| file.getOriginalFilename().endsWith(".png"))
                                {
                                    k.setAttachment(file.getBytes());
                                }
                                else
                                {
					 request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.feedback.error") ;

                                }
                            }
                            else
                            {
					 request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.feedback.error") ;
                            }
                        }
                        
                    }
			service.saveFeedbackComment(k);
			request.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.comment.submitted") ;

		    }
		    catch (Exception exception)
		    {
			    log.error( exception );
		    }
                }
		if ("1".equals(request.getParameter("delete")) && Context.getUserContext().getAuthenticatedUser().hasPrivilege("Admin Feedback")) {
			 try
		    {
			    Feedback s = service.getFeedback((Integer.parseInt (request.getParameter("feedbackId" ) ))) ;
			    service.deleteFeedback(s) ;

		    }
			 catch (Exception exception)
		    {
			    log.error( exception );
		    }
			 			
		}
                			
		String feedbackId = request.getParameter("feedbackId" ) ;
		
		log.debug("Returning feedback text: " + feedbackId);
			
		return feedbackId ;
		
	}

	@Override
	protected Map referenceData(HttpServletRequest req) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		FeedbackService hService = (FeedbackService)Context.getService(FeedbackService.class);
                /*Make sure that the feedback ID is not empty*/
		                
		if ( !"".equals(req.getParameter("feedbackId" )) )
                {   
			try {
				/*This return the feedback object and status to the feedbackform page.*/
				map.put("feedback", hService.getFeedback( (Integer.parseInt (req.getParameter("feedbackId" ) )) ) ) ;		
				if( hService.getFeedback( (Integer.parseInt (req.getParameter("feedbackId" ) )) ) == null )
					{
						req.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.delete") ;
						return map ;
					}
				map.put("statuses", hService.getStatuses() ) ;	
				map.put("comments", hService.getFeedbackComments(Integer.parseInt (req.getParameter("feedbackId" ) )) ) ;
				map.put("feedbackId",req.getParameter("feedbackId" ) ) ;
			}
			catch(Exception exception)
			{
				log.error(exception) ;
				req.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.delete") ;
			}
		}
			
			else 
		{
				req.getSession().setAttribute(WebConstants.OPENMRS_MSG_ATTR, "feedback.notification.delete") ;
		}
                
                
                 return map;
		
	}
	
}