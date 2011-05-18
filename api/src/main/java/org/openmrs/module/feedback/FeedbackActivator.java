package org.openmrs.module.feedback;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.context.Context;
import org.openmrs.module.Activator;
import org.openmrs.module.ModuleException;

public class FeedbackActivator implements Activator {

	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * @see org.openmrs.module.Activator#startup()
	 */
	public void startup() {
		log.info("Starting Hello World module");
		
		AdministrationService as = Context.getAdministrationService();

		// set up requirements
		String gp = as.getGlobalProperty("helloworld.repeatNumber", ""); 
		if ("".equals(gp)) {
			throw new ModuleException("Global property 'helloworld.repeatNumber' must be defined");
		}
	}
	
	/**
	 *  @see org.openmrs.module.Activator#shutdown()
	 */
	public void shutdown() {
		log.info("Shutting down Hello World module");
	}
	
}