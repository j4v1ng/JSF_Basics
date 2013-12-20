package backingbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class SomeBB implements Serializable {

	private static final long serialVersionUID = 7306347922819186071L;
	private boolean condition;

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	public String activateCondition() {
		if (condition) {
			condition = false;
		} else {
			condition = true;
		}
		return "index?faces-redirect=true";
	}

}
