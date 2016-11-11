package ch.thesurvey.model.interfaces;
/**
 * Basic type for users
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
public interface UserInterface extends ModelInterface{

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
     * Set new role for user
     * @param role
     */
    void setRole(String role);

    /**
     * Get role of user
     * @return
     */
    String getRole();

}
