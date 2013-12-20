package backingbeans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
//Always use CDI beans instead of @ManagedBeans 

//When ussing dependency injection, there must be a beans.xml file inside WEB-INF folder(Never forget that)
@Named("cdiBean")//The Named anotation indicates that this is a CDI bean
@SessionScoped//If we use CDI beans the @RequestScoped annotation must come from: javax.enterprise.context.SessionScoped;
public class DemoBB implements Serializable{//Session beans must implement Serializable

	//This value will be saved for that user, while the session is active
	//Note that if a new browser window is opened, that counts as a new session(Another user)
	private String passedValue;

	public String getPassedValue() {
		return passedValue;
	}

	public void setPassedValue(String passedValue) {
		this.passedValue = passedValue;
	}	
}
