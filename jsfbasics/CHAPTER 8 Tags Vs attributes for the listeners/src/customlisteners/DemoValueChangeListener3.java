package customlisteners;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class DemoValueChangeListener3 implements ValueChangeListener {

	@Override
	public void processValueChange(ValueChangeEvent event)
			throws AbortProcessingException {		
		System.out.println("You selected: " + event.getNewValue() + "[Listener 3###]");
	}
}
