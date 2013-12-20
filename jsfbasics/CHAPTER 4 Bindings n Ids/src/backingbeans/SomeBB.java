package backingbeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class SomeBB {

	//This is a representation of the input field "field1"(It is binded to that object)
	private UIComponent field1 = new UIInput();

	public UIComponent getField1() {
		return field1;
	}

	public void setField1(UIComponent field1) {
		this.field1 = field1;
	}	
	
	
	//SIMPLE EXAMPLE:How to obtain component references in Java code
	public void someListener(ActionEvent event) {
		UIComponent component = event.getComponent().findComponent("name");
	}
}
