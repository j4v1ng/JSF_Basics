package backingbeans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UISelectItem;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named("demoBB")
@SessionScoped
public class DemoBB implements Serializable {

	private static final long serialVersionUID = 5780963865793805169L;
	// Set the default selected value of the radio button
	private String selection = "1";
	private String destination = "";

	public void pathHandler(ActionEvent e) {
		if (selection.equals("1")) {
			destination = "pageA";
		} else if (selection.equals("2")) {
			destination = "pageB";
		} else if (selection.equals("3")) {
			destination = "pageC";
		}
	}

	public String act() {
		return destination;
	}

	// Getters & Setters	
	
	public String getDestination() {
		return destination;
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
