package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.ContactInterface;
import ch.thesurvey.model.interfaces.CustomerInterface;

import java.util.Date;
import java.util.List;

/**
 * Created by sam on 23.10.16.
 */
public class Customer implements CustomerInterface{

    private Integer id;
    private String name;
    private Integer status;

    private Integer points;
    private Date datetime;

    private List<ContactInterface> contacts;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return datetime;
    }

    public void setTimestamp(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public List<ContactInterface> getContacts() {
        return contacts;
    }

    @Override
    public void setContacts(List<ContactInterface> contactInterfaces) {
        this.contacts = contacts;
    }

    @Override
    public void addContact(ContactInterface contact) {
        contacts.add(contact);
    }
}
