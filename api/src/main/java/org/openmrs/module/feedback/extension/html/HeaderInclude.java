/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.feedback.extension.html;

/**
 *
 * @author gaurav
 */
import java.util.List;
import java.util.ArrayList;
import org.openmrs.module.web.extension.HeaderIncludeExt;

public class HeaderInclude extends HeaderIncludeExt {

        public List<String> getHeaderFiles() {
                List<String> myHeaderFiles = new ArrayList<String>();
                myHeaderFiles.add("/moduleResources/feedback/fdbk.js");                
                return myHeaderFiles;
        }
}

