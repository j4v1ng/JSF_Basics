package backingbeans;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named//uses CDI
@SessionScoped
public class LocaleManagementBean implements Serializable{
//TODO: Find out why this localizes only the current page
     public void changeLanguage() {
    	 FacesContext context = FacesContext.getCurrentInstance();  
         if(context.getViewRoot().getLocale().getLanguage().contains("de")) {
        	 //Change to english
        	 context.getViewRoot().setLocale(new Locale("en"));
         }
         else {
        	 //change to german
        	 context.getViewRoot().setLocale(new Locale("de"));
         }
     }
}
