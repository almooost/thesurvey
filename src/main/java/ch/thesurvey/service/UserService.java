package ch.thesurvey.service;

import ch.thesurvey.model.User;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.UserInterface;
import ch.thesurvey.persistence.dao.UserDao;
import ch.thesurvey.persistence.dao.interfaces.UserDaoInterface;
import ch.thesurvey.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Service for abstracting user dao
 * @author Samuel Alfano
 * @date 01.11.2016
 * @version v0.2
 */
@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserDaoInterface  dao;

    @Transactional
    public ModelInterface findById(Integer id) {
        return dao.findById(id);
    }

    @Transactional
    public List<ModelInterface> findAll(ModelInterface model) {
        return dao.findAll(model);
    }

    @Transactional
    public void persist(ModelInterface model) {
        dao.save(model);
    }

    @Transactional
    public void remove(ModelInterface model) {
        dao.remove(model);
    }

    @Transactional
    public UserInterface findByUser(UserInterface model) {
        return dao.findByUser(model);
    }

    public boolean authenticateUser(Integer userId, String password) {
        UserInterface user = (UserInterface)dao.findById(userId);
        if(user!=null && user.getId().equals(userId) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
