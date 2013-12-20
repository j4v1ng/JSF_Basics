package backingbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("bbb")
@SessionScoped
public class BackBeanB implements Serializable {

	private static final long serialVersionUID = -4786092545430477941L;

	private String something;

	@PostConstruct
	public void init() {
		something = "Some value in Bean 'B'";
	}
	
	public String getSomething() {
		return something;
	}

	public void setSomething(String something) {
		this.something = something;
	}
}
