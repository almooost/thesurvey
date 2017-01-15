package ch.thesurvey.service.interfaces;

import ch.thesurvey.model.interfaces.UserInterface;

/**
 * Service interface for more abstraction
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
public interface UserServiceInterface extends ServiceInterface{

    UserInterface findByUser(UserInterface model);

    boolean authenticateUser(Integer userId, String password);
}
