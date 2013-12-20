package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBackingBean {

	private String input;
	
	public String login() {
		if(input.equals("admin")) {
			/*It is a good practice to use always ?faces-redirect=true
			(If you are not using navigation rules), this way you make sure that
			in the URL the correct page name is displayed. Notice that the URL does
			not change if it is not added.
			*/
			return "destination?faces-redirect=true";
		}
		return null;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
}
