package ch.thesurvey.utility;

import ch.thesurvey.model.interfaces.ContactInterface;
import ch.thesurvey.model.interfaces.SurveyContactInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * Custom mail class for sending mail to contacts
 * @author Samuel Alfano
 * @date 25.11.2016
 * @version v0.1
 */
@PropertySource("classpath:application.properties")
public class Mail {

    private List<SurveyContactInterface> contactList;

    @Value("${spring.mail.smtp}")
    private String smtp;

    @Value("${spring.mail.port}")
    private Integer smtpPort;

    @Value("${spring.mail.username}")
    private String user;

    @Value("${spring.mail.password}")
    private String password;

    private SurveyInterface survey;

    public String getSmtp() {return smtp;}

    public void setSmtp(String smtp) {this.smtp = smtp;}

    public Integer getSmtpPort() {return smtpPort;}

    public void setSmtpPort(Integer smtpPort) {this.smtpPort = smtpPort;}

    public String getUser() {return user;}

    public void setUser(String user) {this.user = user;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public void setSurvey(SurveyInterface survey){this.survey = survey;}

    public SurveyInterface getSurvey(){return this.survey;}

    public void setContactList(List<SurveyContactInterface> contactList){this.contactList = contactList;}

    private List<SurveyContactInterface> getContactList(){return contactList;}

    public boolean send() throws MessagingException {

        // Set mailserver settings
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        Properties mailProperties = System.getProperties();
        mailProperties.put("mail.smtp.host", getSmtp());
        mailProperties.put("mail.smtp.port", getSmtpPort());
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Create email
        System.out.println("\n\n 2nd ===> get Mail Session..");
        Session mailSession = Session.getDefaultInstance(mailProperties, null);
        /*
        Session mailSession = Session.getDefaultInstance(mailProperties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("alfano.eth0", "M@1à4TestingProbs!Really");
            }
        });
        */
        MimeMessage mimeMessage = new MimeMessage(mailSession);
        mimeMessage.setSender(new InternetAddress("alfano@eth0.ch"));
        mimeMessage.setFrom(new InternetAddress("alfano@eth0.ch"));

        /*
        for (SurveyContactInterface surveyContact: getSurveyContacts()) {
            if(!surveyContact.getContact().getEmail().contentEquals(""))
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(surveyContact.getContact().getEmail()));

        }
*/
//        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("sam.almost@gmail.com"));
        mimeMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("samuel.alfano@students.ffhs.ch"));


        mimeMessage.setSubject("Test Subject von The Survey");
        String emailBody = "Test email body " + "<br><br> Regards, <br>Sam Ori";
        mimeMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");

        // create new trasnport for sending
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = mailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect(getSmtp(), getUser(), getPassword());

        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("\n\n 4rd ===> E-Mails sent! Proceeding");

        // Set status to running/executed
        getSurvey().setStatus(8);

        return true;
    }

}
