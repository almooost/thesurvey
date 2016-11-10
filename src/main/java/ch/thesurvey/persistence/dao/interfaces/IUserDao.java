package ch.thesurvey.persistence.dao.interfaces;

import ch.thesurvey.model.interfaces.IUser;

import java.util.List;

/**
 * Created by sam on 06.11.16.
 */
public interface IUserDao {

    IUser findByUser(IUser model);

    IUser findById(Integer userId);

    List<IUser> findAll(IUser model );

    void save(IUser model);

    void remove(IUser model);
}
