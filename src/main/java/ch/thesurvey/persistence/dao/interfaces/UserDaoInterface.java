package ch.thesurvey.persistence.dao.interfaces;

import ch.thesurvey.model.interfaces.UserInterface;

/**
 * User Data Access Object for db interactions
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
public interface UserDaoInterface extends DaoInterface {

    /**
     * Find user by its username
     * @param model
     * @return
     */
    UserInterface findByUser(UserInterface model);
}
