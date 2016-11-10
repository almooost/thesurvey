package ch.thesurvey.service.interfaces;

import ch.thesurvey.model.interfaces.IUser;

import java.util.List;

/**
 * Created by sam on 06.11.16.
 */
public interface IUserService {

    IUser findById(Integer userId);

    List<IUser> findAll(IUser model);

    void persist(IUser model);

    void remove(IUser model);

    public IUser findByUser(IUser model);

    public boolean authenticateUser(Integer userId, String password);
}
