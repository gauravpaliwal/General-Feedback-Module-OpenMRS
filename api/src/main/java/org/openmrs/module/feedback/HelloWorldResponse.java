package org.openmrs.module.feedback;

/**
 * Hello World Saying
 * 
 * @author Ben Wolfe
 * @version 1.0
 */
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