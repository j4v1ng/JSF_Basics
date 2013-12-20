package backingbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("bba")
@SessionScoped
public class BackBeanA implements Serializable {

	private static final long serialVersionUID = 5671761649767605303L;

	@Inject
	private BackBeanB b;

	public String salute() {
		return "Hi! I am 'A'";
	}

	public BackBeanB getB() {
		return b;
	}

	public void setB(BackBeanB b) {
		this.b = b;
	}
}
