package backingbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class SimpleBackingBean implements Serializable {

	private static final long serialVersionUID = -1871317298175691518L;
	private String simpleValue = "Some value in the backing bean";
	private String recievedValue;

	public String getTheValuesFromTheURL() {
		String passedValue = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("param");

		return passedValue;
	}

	public String getRecievedValue() {
		return recievedValue;
	}

	public void setRecievedValue(String recievedValue) {
		this.recievedValue = recievedValue;
	}

	public String getSimpleValue() {
		return simpleValue;
	}

	public void setSimpleValue(String simpleValue) {
		this.simpleValue = simpleValue;
	}
}
