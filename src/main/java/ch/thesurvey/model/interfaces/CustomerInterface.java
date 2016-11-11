package ch.thesurvey.model.interfaces;

import java.util.List;

/**
 * Basic type for customers
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
public interface CustomerInterface extends ModelInterface {

    /**
     * Get list of contacts from customer
     * @return contacts
     */
    List<ContactInterface> getContacts();

    /**
     * Set new contact list for customer
     * @param contactInterfaces
     */
    void setContacts(List<ContactInterface> contactInterfaces);

    /**
     * Add new single contact
     * @param contact
     */
    void addContact(ContactInterface contact);
}
