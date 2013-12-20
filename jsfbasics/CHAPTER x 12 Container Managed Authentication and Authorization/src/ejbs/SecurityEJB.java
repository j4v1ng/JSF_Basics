package ejbs;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

@Stateless
public class SecurityEJB {

	
	
	@RolesAllowed({"admin"})
	public void administrativeAction() {	
			System.out.println("THIS ACTION WAS TRIGGERED BY AN ADMINISTRATOR");
			//CRUD OPERATIONS ON PERSISTENT DATA CAN GO HERE
	}
	
}
