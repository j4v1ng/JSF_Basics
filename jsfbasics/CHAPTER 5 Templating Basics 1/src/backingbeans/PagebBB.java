package backingbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//Managed Beans need to have a name and a scope
//The package of SessionScoped should be javax.enterprise.context.SessionScoped;
@Named("pagebBB")
@SessionScoped
public class PagebBB implements Serializable {

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

	public String getGreetingMsg() {
		if (name != null && password != null) {
			if (name.length() > 0 && password.length() > 0) {
				return "Welcome to JSF + AJAX demo " + getName()
						+ " your password is " + getPassword();
			} else {
				return "Enter a name and a password";
			}
		}
		return "";
	}
}