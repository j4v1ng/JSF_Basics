package backingbeans;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named("user")
@SessionScoped
public class UserBB implements Serializable {

	private String nickname;

	// action listener event
	public void attrListener(ActionEvent event) {
		//getting the attribute value from the comment that generated the event
		nickname = (String) event.getComponent().getAttributes()
				.get("username");

	}

	//This is how you could return the param saved in the context:
	
	//get value from "f:param"
	public String getCountryParam(FacesContext fc){
 
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("country");
 
	}
 
	
	public String outcome(){
		return "result";
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}	
}