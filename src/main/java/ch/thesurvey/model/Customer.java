package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.ContactInterface;
import ch.thesurvey.model.interfaces.CustomerInterface;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Model represents customer in system
 * @author Samuel Alfano
 * @version v0.2
 */
@Entity
@Table(name = "customer")
public class Customer implements CustomerInterface{

    private Integer id;
    private String name;
    private Integer status;

    private Date datetime;

    private List<ContactInterface> contacts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "timestamp")
    public Date getTimestamp() {
        return datetime;
    }

    public void setTimestamp(Date datetime) {
        this.datetime = datetime;
    }

    @Transient
    public List<ContactInterface> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactInterface> contactInterfaces) {
        this.contacts = contacts;
    }

    public void addContact(ContactInterface contact) {
        contacts.add(contact);
    }
}
