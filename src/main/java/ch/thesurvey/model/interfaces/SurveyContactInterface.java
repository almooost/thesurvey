package ch.thesurvey.model.interfaces;

import java.util.Date;

/**
 * Interface for mapping contacts to surveys
 * @author Samuel Alfano
 * @date 21.11.2016
 * @version v0.2
 */
public interface SurveyContactInterface extends ModelInterface{

    /**
     * Get current survey
     * @return
     */
    SurveyInterface getSurvey();

    /**
     * Set new survey to list
     * @param survey
     */
    void setSurvey(SurveyInterface survey);

    /**
     * Get Contact
     * @return
     */
    ContactInterface getContact();

    /**
     * Set a new contact in the contact survey list
     * @param contact
     */
    void setContact(ContactInterface contact);

    /**
     * Get current token
     * @return
     */
    String getToken();

    /**
     * Set new token
     * @param token
     */
    void setToken(String token);

    /**
     * Get max age of token
     * @return Date
     */
    Date getTokenUntil();

    /**
     * Set max age of token
     * @param tokenUntil
     */
    void setTokenUntil(Date tokenUntil);
}
