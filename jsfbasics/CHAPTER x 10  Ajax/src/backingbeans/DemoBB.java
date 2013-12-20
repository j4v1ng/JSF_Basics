package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("demoBB")
@RequestScoped
public class DemoBB {

	private String name;
	private String example2Val1;
	private String example2Val2;
	private String example3Val1;
	private String example3Val2;
	private String example4Val1;
	private String example5Val1;

	public void input1Click() {
		System.out.println("You clicked in input 1");
	}

	public void input2Click() {
		System.out.println("You clicked in input 2");
	}

	public void input3KeyUp() {
		System.out.println("Key pressed on input 3");
	}

	public void input4MouseOver() {
		System.out.println("Mouse is over");
	}

	public void validateExample5(FacesContext fc, UIComponent c, Object value) {
		if(  ((String)value).contains("_") ) {
			throw new ValidatorException(new FacesMessage("No underscores allowed"));
		}
	}
	
	// GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExample2Val1() {
		return example2Val1;
	}

	public void setExample2Val1(String example2Val1) {
		this.example2Val1 = example2Val1;
	}

	public String getExample2Val2() {
		return example2Val2;
	}

	public void setExample2Val2(String example2Val2) {
		this.example2Val2 = example2Val2;
	}

	public String getExample3Val1() {
		return example3Val1;
	}

	public void setExample3Val1(String example3Val1) {
		this.example3Val1 = example3Val1;
	}

	public String getExample3Val2() {
		return example3Val2;
	}

	public void setExample3Val2(String example3Val2) {
		this.example3Val2 = example3Val2;
	}

	public String getExample4Val1() {
		return example4Val1;
	}

	public void setExample4Val1(String example4Val1) {
		this.example4Val1 = example4Val1;
	}

	public String getExample5Val1() {
		return example5Val1;
	}

	public void setExample5Val1(String example5Val1) {
		this.example5Val1 = example5Val1;
	}	
}
