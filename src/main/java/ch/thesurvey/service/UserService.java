package ch.thesurvey.service;

import ch.thesurvey.model.IModel;
import ch.thesurvey.model.interfaces.IUser;
import ch.thesurvey.persistence.dao.interfaces.IUserDao;
import ch.thesurvey.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by sam on 23.10.16.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Transactional
    public IUser findById(Integer userId) {
        return userDao.findById(userId);
    }

    @Transactional
    public List<IUser> findAll(IUser model) {
        return userDao.findAll(model);
    }

    @Transactional
    public void persist(IUser model) {
        userDao.save(model);
    }

    @Transactional
    public void remove(IUser model) {
        userDao.remove(model);
    }

    @Transactional
    public IUser findByUser(IUser model) {
        return userDao.findByUser(model);
    }

    public boolean authenticateUser(Integer userId, String password) {
        IUser user = userDao.findById(userId);
        if(user!=null && user.getId().equals(userId) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

}
