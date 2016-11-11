package ch.thesurvey.model.interfaces;

import java.util.Date;

/**
 * Created by sam on 10.11.16.
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
