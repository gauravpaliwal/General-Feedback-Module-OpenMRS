/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.feedback.extension.html;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openmrs.module.Extension;
import org.openmrs.module.web.extension.AdministrationSectionExt;
import org.openmrs.module.web.extension.LinkExt;
import org.openmrs.module.web.extension.PortletExt;
/**
 *
 * @author gaurav
 */
public class FeedbackForm extends PortletExt {

    public String getLabel() {
        return "Submit Feedback" ;
    }

    public String getUrl() {
        return "javascript:test()" ;
    }

    public String getRequiredPrivilege() {
        return "Add Feedback Criteria";
    }

    public String getPortletUrl() {
        return "newjsp";
    }

    public String getPortletParameters() {
        return null ;
    }

    
}
