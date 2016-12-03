package ch.thesurvey.utility;

import ch.thesurvey.model.interfaces.SurveyContactInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.List;

/**
 * Custom mail class for sending mail to contacts
 * @author Samuel Alfano
 * @date 25.11.2016
 * @version v0.3
 */
public class SurveyMail {

    private List<SurveyContactInterface> contactList;

    private SurveyInterface survey;

    public void setSurvey(SurveyInterface survey){this.survey = survey;}

    public SurveyInterface getSurvey(){return this.survey;}

    public void setContactList(List<SurveyContactInterface> contactList){this.contactList = contactList;}

    private List<SurveyContactInterface> getContactList(){return contactList;}

    private JavaMailSender mailSender;

    public void setMailSender(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public SurveyMail(){}

    public SurveyMail(JavaMailSender mailSender, SurveyInterface survey, List<SurveyContactInterface> contactList){
        this.mailSender = mailSender;
        this.survey = survey;
        this.contactList = contactList;
    }

    public boolean send(String fromAddress, String subject, String msgBody){

        for(SurveyContactInterface contact : getContactList()){

            msgBody = msgBody+"\n\nIhr Token: http://localhost:8080/live/?id="+getSurvey().getId()+"&token="+contact.getToken();
            msgBody = msgBody+"\n\nBesten Dank\n\nIhr Survey Team";

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(contact.getContact().getEmail());
            mailMessage.setReplyTo(fromAddress);
            mailMessage.setFrom(fromAddress);
            mailMessage.setSubject(subject);
            mailMessage.setText(msgBody);
            mailSender.send(mailMessage);
        }
        return true;
    }

}
