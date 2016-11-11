package ch.thesurvey.service.interfaces;

import ch.thesurvey.model.interfaces.UserInterface;

import java.util.List;

/**
 * Service interface for more abstraction
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
public interface UserServiceInterface extends ServiceInterface{

    public UserInterface findByUser(UserInterface model);

    public boolean authenticateUser(Integer userId, String password);
}
