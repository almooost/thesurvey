package ch.thesurvey.model.interfaces;

import java.util.Date;

/**
 * Represents general model, implemented by normal model classes
 * @author Samuel Alfano
 * @date 24.10.2016
 * @version v0.1
 */
public interface ModelInterface {

    /**
     * Id of answer object
     * @return id
     */
    Integer getId();

    /**
     * Set new id
     * @param id
     */
    void setId(Integer id);

    /**
     * Name of answer object
     * @return name
     */
    String getName();

    /**
     * String set new name
     * @param name
     */
    void setName(String name);

    /**
     * Status of answer object
     * @return status
     */
    Integer getStatus();

    /**
     * Set new status
     * @param status
     */
    void setStatus(Integer status);

    /**
     * Get current datetime
     * @return
     */
    Date getTimestamp();

    /**
     * Set new timestamp
     * @param datetime
     */
    void setTimestamp(Date datetime);
}
