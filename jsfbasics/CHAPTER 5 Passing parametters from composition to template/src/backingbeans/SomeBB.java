package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("someBB")
@RequestScoped
public class SomeBB {

	private String something;

	
	public SomeBB() {
		something = "THIS IS SOME DEFAULT VALUE";
	}
	
	public String getSomething() {
		return something;
	}

	public void setSomething(String something) {
		this.something = something;
	}
}
