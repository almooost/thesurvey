package ch.thesurvey.model.interfaces;

/**
 * Basic type for contact
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
public interface ContactInterface extends ModelInterface {

    /**
     * Get contact givenname
     * @return givenname
     */
    String getGivenname();

    /**
     * Set new contact givenname
     * @param givenname
     */
    void setGivenname(String givenname);

    /**
     * Get email of contact
     * @return
     */
    String getEmail();

    /**
     * Set new email
     * @param email
     */
    void setEmail(String email);

    /**
     * Get department where the contact is working
     * @return department
     */
    String getDepartment();

    /**
     * Set new department
     * @param department
     */
    void setDepartment(String department);
}
