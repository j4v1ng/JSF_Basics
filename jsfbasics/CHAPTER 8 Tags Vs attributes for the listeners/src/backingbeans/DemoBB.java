package backingbeans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named("demoBB")
@RequestScoped
public class DemoBB {

	
	private String selectedOption;
	
	private List<String> options;
	
	public DemoBB() {
		options = new ArrayList<String>();
		options.add("Option A");
		options.add("Option B");
		options.add("Option C");
	}
	
	public String getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}	
}
