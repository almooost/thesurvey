package ch.thesurvey.model.interfaces;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

/**
 * Created by sam on 06.11.16.
 */
public interface IUser {


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
    String getUsername();

    /**
     * Set new username
     * @param username
     */
    void setUsername(String username);

    /**
     * Get existing password for validation
     * @return
     */
    String getPassword();

    /**
     * Set new password for user
     * @param password
     */
    void setPassword(String password);

    /**
     * Set new givennname for user
     * @param givenname
     */
    void setGivenname(String givenname);

    /**
     * Get givenname of user
     * @return
     */
    String getGivenname();

    /**
     * Set new lastname for user
     * @param lastname
     */
    void setLastname(String lastname);

    /**
     * Get lastname of user
     * @return
     */
    String getLastname();

    /**
     * Set new role for user
     * @param role
     */
    void setRole(String role);

    /**
     * Get role of user
     * @return
     */
    String getRole();

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

    /**
     * Check login
     * @return
     */
    //boolean login() throws Exception;

}
