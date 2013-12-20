package backingbeans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.inject.Named;

@Named("demoBB")
@RequestScoped
public class DemoBB {

	private String adress;
	private String city;
	private String province;
	private String country;
	private List<String> countries;

	public DemoBB() {
		countries = new ArrayList<String>();
		countries.add("Spain");
		countries.add("France");
		countries.add("Italy");
		countries.add("UK");
	}

	public void changeTheLocale(ValueChangeEvent event) {
		System.out.println("The locale was changed(JUST A SIMULATION!)");

		FacesContext context = FacesContext.getCurrentInstance();
		// Skip the validation and go directly to the render phase
		context.renderResponse();
	}

	// Getters & Setters
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
}
