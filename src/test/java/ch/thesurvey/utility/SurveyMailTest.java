package ch.thesurvey.utility;

import ch.thesurvey.AbstractTest;
import ch.thesurvey.model.Contact;
import ch.thesurvey.model.Survey;
import ch.thesurvey.model.SurveyContact;
import ch.thesurvey.model.interfaces.ContactInterface;
import ch.thesurvey.model.interfaces.SurveyContactInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Test if survey mail service still works
 * @author Samuel Alfano
 * @version v0.1
 */
public class SurveyMailTest extends AbstractTest{

    SurveyInterface survey;
    SurveyMail mail;

    @Autowired
    JavaMailSender javaMailSender;

    @Before
    public void setUp(){

        List<SurveyContactInterface> contactList = new ArrayList<SurveyContactInterface>();
        ContactInterface contact = new Contact();
        contact.setId(1);
        contact.setStatus(1);
        contact.setEmail("alfano@eth0.ch");
        contact.setDepartment("IT");
        contact.setGivenname("Sam");
        contact.setName("Ori");
        SurveyContactInterface surveyContact = new SurveyContact();
        surveyContact.setName("test");
        surveyContact.setContact(contact);
        contactList.add(surveyContact);

        survey = new Survey();
        survey.setName("UnitTest Survey");
        survey.setDescription("UnitTest Description");
        survey.setId(1010101);
        survey.setSurveyContacts(contactList);
        try {
            survey.setStartDate(SimpleDateFormat.getDateInstance().parse("21.12.2016"));
            survey.setEndDate(SimpleDateFormat.getDateInstance().parse("24.12.2016"));
        }catch (Exception e){
            logger.debug("SurveyMailTest - Failed converting dates");
        }

        mail = new SurveyMail();
    }

    @After
    public void tearDown(){
        survey = null;
        mail = null;
    }

    @Test
    public void sendMailTest(){
        // TODO Check if connection works
        SurveyMail mail = new SurveyMail(javaMailSender, survey, survey.getSurveyContacts());

        boolean success = mail.send("alfano@eth0.ch", survey.getName(), survey.getDescription());

        Assert.assertEquals("Connection to mailserver works", true, success);
    }
}
