package org.openmrs.module.feedback.web;

//~--- non-JDK imports --------------------------------------------------------

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.openmrs.api.context.Context;
import org.openmrs.module.feedback.Feedback;
import org.openmrs.module.feedback.FeedbackService;

import org.springframework.web.servlet.mvc.SimpleFormController;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class forwardFeedbackFormController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log log = LogFactory.getLog(getClass());

    @Override
    protected String formBackingObject(HttpServletRequest request) throws Exception {

        /* Make sure that neither the status not the comment is empty or Null */
        Object          o       = Context.getService(FeedbackService.class);
        FeedbackService service = (FeedbackService) o;

        if (!"".equals(request.getParameter("status")) &&!"".equals(request.getParameter("comment"))) {
            try {
                Feedback s = service.getFeedback((Integer.parseInt(request.getParameter("feedbackId"))));

                s.setStatus(request.getParameter("status"));
                s.setComment(request.getParameter("comment"));
                service.saveFeedback(s);
            } catch (Exception exception) {
                log.error(exception);
            }
        }

        if ("1".equals(request.getParameter("delete"))
                && Context.getUserContext().getAuthenticatedUser().hasPrivilege("Admin Feedback")) {
            try {
                Feedback s = service.getFeedback((Integer.parseInt(request.getParameter("feedbackId"))));

                service.deleteFeedback(s);
            } catch (Exception exception) {
                log.error(exception);
            }
        }

        String feedbackId = request.getParameter("feedbackId");

        log.debug("Returning feedback text: " + feedbackId);

        return feedbackId;
    }

    @Override
    protected Map referenceData(HttpServletRequest req) throws Exception {
        Map<String, Object> map      = new HashMap<String, Object>();
        FeedbackService     hService = (FeedbackService) Context.getService(FeedbackService.class);

        /* Make sure that the feedback ID is not empty */

        if (!"".equals(req.getParameter("feedbackId"))) {
            try {

                /* This return the feedback object and status to the feedbackform page. */
                map.put("feedback", hService.getFeedback((Integer.parseInt(req.getParameter("feedbackId")))));

                if (hService.getFeedback((Integer.parseInt(req.getParameter("feedbackId")))) == null) {
                    map.put("feedbackPageMessage", "feedback.notification.delete");

                    return map;
                }

                map.put("statuses", hService.getStatuses());
            } catch (Exception exception) {
                log.error(exception);
                map.put("feedbackPageMessage", "feedback.notification.delete");
            }
        } else {
            map.put("feedbackPageMessage", "feedback.notification.delete");
        }

        return map;
    }
}

