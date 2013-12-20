package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
//Always use CDI beans instead of @ManagedBeans 

@Named("cdiBean")//The Named anotation indicates that this is a CDI bean
@RequestScoped//If we use CDI beans the @RequestScoped annotation must come from: javax.enterprise.context.RequestScoped;
//When ussing dependency injection, there must be a beans.xml file inside WEB-INF folder(Never forget that)
public class DemoBB {//It is a good practice to implement Serializable(Even if no needed for RequestScoped beans)

	//This value will be saved on the session only until the server responds to the request
	private String passedValue;

	public String getPassedValue() {
		return passedValue;
	}

	public void setPassedValue(String passedValue) {
		this.passedValue = passedValue;
	}	
}
