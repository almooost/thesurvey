package ch.thesurvey.service;

import ch.thesurvey.AbstractTest;
import ch.thesurvey.model.Contact;
import ch.thesurvey.model.interfaces.ContactInterface;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.service.interfaces.ContactServiceInterface;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Test if DB Connection via ContactService works
 * @author Samuel Alfano
 * @version v0.1
 */
@Transactional
public class ContactServiceTest extends AbstractTest {

    @Autowired
    private ContactServiceInterface contactService;

    private ContactInterface contact;

    @Before
    public void setUp(){
        contact = new Contact();
        contact.setGivenname("Hans");
        contact.setName("Muster");
        contact.setDepartment("Testing - IT");
        contact.setEmail("hans.muester@trash-mail.com");
        contact.setStatus(1);
        try {
            contact.setTimestamp(SimpleDateFormat.getDateInstance().parse("24.12.2016"));
        }catch (Exception e){
            logger.debug("ContactServiceTest date conversion failed");
        }
    }

    @After
    public void tearDown(){
        contact = null;
    }

    @Test
    public void findAllTest(){
        List<ModelInterface> contactList = contactService.findAll(new Contact());

        Assert.assertNotNull("failure - expected not null", contactList);

        boolean hasElements = contactList.size() >= 1 ? true : false;

        Assert.assertEquals("failure - expected size 1", true, hasElements);
    }

    @Test
    public void persistTest(){
        contactService.persist(contact);
        boolean success = contact.getId() != null;
        Assert.assertEquals("Contact could be persisted", true, success);
    }

    @Test
    public void removeTest(){

        List<ModelInterface> contactList = contactService.findAll(new Contact());

        contact = (ContactInterface)contactList.get(0);

        Integer contactId = contact.getId();

        contactService.remove(contact);

        ModelInterface removedContact = contactService.findById(contactId);

        boolean removed = removedContact == null;

        Assert.assertEquals("Contact removed sucessful",true, removed);

    }

}
