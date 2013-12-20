package backingbean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("bd")
@RequestScoped
public class BeanDemo {

	private String value;

	//This is great for initializing variables that the bean will need
	@PostConstruct
	public void method1() {
		value = "Some value";
		System.out.println("The bean just created!");
	}

	//This is great to liberate or release resources that are not needed when
	//the bean goes out of scope
	@PreDestroy
	public void method2() {
		value = "";
		System.out.println("The bean will be destroyed!");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
