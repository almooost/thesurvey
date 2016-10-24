package ch.thesurvey.model;

import java.util.Date;

/**
 * Created by sam on 23.10.16.
 */
public interface IModel {

    /**
     * Get id of model
     * @return
     */
    Integer getId();

    /**
     * Set new id form model
     * @param id
     */
    void setId(Integer id);

    /**
     * Get name of model
     * @return
     */
    String getName();

    /**
     * Set new name
     * @param name
     */
    void setName(String name);

    /**
     * Get current timestamp
     * @return Date
     */
    Date getTimestamp();

    /**
     * Set new timestamp
     * @param datetime
     */
    void setTimestamp(Date datetime);

    /**
     * Get current status of model
     * @return Integer
     */
    Integer getStatus();

    /**
     * Set status of model
     * @param status
     */
    void setStatus(Integer status);
}
