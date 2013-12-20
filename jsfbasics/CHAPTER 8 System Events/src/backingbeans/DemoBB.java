package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("demoBB")
@RequestScoped
public class DemoBB {

	private String field;

	
	public void method1() {
		System.out.println("You are in the postValidate phase ");
	}		
	
	//Getters and Setters
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}	
}
