package ejbs;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejbinterfaces.EmailService;

@Stateless(name = "ejbs/EmailServiceImpl")
public class EmailServiceImpl implements EmailService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource(name = "mail/myMailSession")
	private Session mailSession;

	/* (non-Javadoc)
	 * @see ejbs.EmailService#sendAccountActivationLinkToBuyer(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendEmailToDestination(String destinationEmail) {

		// Destination of the email
		String to = destinationEmail;
		String from = "dontreply2thismessage@gmail.com";

		try {
			Message message = new MimeMessage(mailSession);
			// From: is our service
			message.setFrom(new InternetAddress(from));
			// To: destination given
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			//Set a subject
			message.setSubject("Sending mail with java");
			
			/* Set the content of the email(Only if the message is not multipart)
			message.setContent("<h3>This is the content of the email(HTML markup)</h3><br/>", "text/html");
            */
			// Prepare a multipart(Html + images) 
			Multipart multipart = new MimeMultipart();
			// Prepare the HTML part The part: <img src=\"cid:logoimg_cid\"/> will insert the image in the content(Otherwise would be sent as an attachment)
			BodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent("<h3>This is the content of the email(HTML markup)</h3><img src=\"cid:logoimg_cid\"/>", "text/html");
			htmlPart.setDisposition(BodyPart.INLINE);

			// PREPARE THE IMAGE part
			BodyPart imgPart = new MimeBodyPart();

			String fileName = "logoemailtemplate.png";

			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			
			DataSource ds = new URLDataSource(classLoader.getResource(fileName));

			imgPart.setDataHandler(new DataHandler(ds));
			imgPart.setHeader("Content-ID", "<logoimg_cid>");
			imgPart.setDisposition(MimeBodyPart.INLINE);
			imgPart.setFileName("logomailtemplate.png");
			
			//Link Html + images together
			multipart.addBodyPart(htmlPart);
			multipart.addBodyPart(imgPart);
			// Set the message content!
			message.setContent(multipart);			
			//Send the message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
}
