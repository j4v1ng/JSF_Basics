package backingbeans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ejbinterfaces.EmailService;

@Named("supportBB")
@RequestScoped
public class SupportBB {

	@EJB
	private EmailService emailService;
	
	private String destinationEmail;

	
	public String sendMail() {
		try {
		emailService.sendEmailToDestination(destinationEmail);
		}
		catch (Exception e) {
			System.err.println("Something whent wrong(Check your mail configuration!)");
		}
		return "";
	}	
	
	
	public String getDestinationEmail() {
		return destinationEmail;
	}

	public void setDestinationEmail(String destinationEmail) {
		this.destinationEmail = destinationEmail;
	}	
}
