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

package org.openmrs.module.feedback;


public class HelloWorldResponse implements java.io.Serializable {

	public static final long serialVersionUID = 113222232L;

	// Fields

	private Integer helloWorldResponseId;
	private Boolean retired = false;
	private String response;

	// Constructors

	/** default constructor */
	public HelloWorldResponse() {
	}

	/** constructor with id */
	public HelloWorldResponse(Integer helloWorldResponseId) {
		this.helloWorldResponseId = helloWorldResponseId;
	}

	public boolean equals(Object obj) {
		if (obj instanceof HelloWorldResponse) {
			HelloWorldResponse t = (HelloWorldResponse)obj;
			if (this.getHelloWorldResponseId() != null && t.getHelloWorldResponseId() != null)
				return (this.getHelloWorldResponseId().equals(t.getHelloWorldResponseId()));
		}
		return false;
	}
	
	public int hashCode() {
		if (this.getHelloWorldResponseId() == null) return super.hashCode();
		return this.getHelloWorldResponseId().hashCode();
	}

	// Property accessors

	public String getResponse() {
		return response;
	}

	public void setResponse(String saying) {
		this.response = saying;
	}

	public Boolean isRetired() {
		if (retired == null)
			return false;
		return retired;
	}
	
	public Boolean getRetired() {
		return isRetired();
	}

	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	public Integer getHelloWorldResponseId() {
		return helloWorldResponseId;
	}

	public void setHelloWorldResponseId(Integer id) {
		this.helloWorldResponseId = id;
	}

}