package backingbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("bba")
@SessionScoped
public class BackingBeanA implements Serializable {

	private String property;

	@PostConstruct
	public void init() {
		property = "Default value";
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String simpleMethod() {
		return "This is a simple method";
	}

	public String parametrizedSimpleMethod(String value) {
		return value;
	}
}
