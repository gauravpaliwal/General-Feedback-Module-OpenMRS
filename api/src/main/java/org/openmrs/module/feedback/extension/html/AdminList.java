package org.openmrs.module.feedback.extension.html;

import java.util.HashMap;
import java.util.Map;

import org.openmrs.module.Extension;
import org.openmrs.module.web.extension.AdministrationSectionExt;

public class AdminList extends AdministrationSectionExt {
	
	public Extension.MEDIA_TYPE getMediaType() {
		return Extension.MEDIA_TYPE.html;
	}
	
	public String getTitle() {
		return "Feedback Module";
	}
	
	public Map<String, String> getLinks() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("module/feedback/addSeverity.form", "Add Severity Level");
		map.put("module/feedback/addStatus.form", "Add Status");
                map.put("module/feedback/addPredefinedSubject.form", "Add Predefined Subject");

                return map;
	}
	
}