package backingbeans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

//When ussing dependency injection, there must be a beans.xml file inside WEB-INF folder(Never forget that)
@Named("cdiBean")//The Named anotation indicates that this is a CDI bean
@ApplicationScoped
public class DemoBB {//It is not mandatory, but it is recommended to always implement Serializable

	//This value will be saved all the time while the application is running on the server	
	//Even if we open a new browser.
	//The value is now attached to the application,an no to a concrete user
	private String passedValue;

	public String getPassedValue() {
		return passedValue;
	}

	public void setPassedValue(String passedValue) {
		this.passedValue = passedValue;
	}	
}
