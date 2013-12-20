package managedbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//Managed Beans need to have a name and a scope
//The package of SessionScoped should be javax.enterprise.context.SessionScoped;
@Named("usermb")
@SessionScoped
public class UserMB implements Serializable{
	
	private static final long serialVersionUID = -8090534060790081503L;
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	//This will be called this way: #{usermb.redirect}" (Notice there is no need for get prefix)
	public String redirect() {
		return "Welcome";
	}
}
