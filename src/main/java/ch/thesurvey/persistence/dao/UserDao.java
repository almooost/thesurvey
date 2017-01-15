package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.User;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.UserInterface;
import ch.thesurvey.persistence.dao.interfaces.UserDaoInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Object for accessing the database
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
@Repository
public class UserDao extends AbstractDao implements UserDaoInterface {

    @Transactional
    public UserInterface findByUser(UserInterface model) {

        String hql = "from User u where u.username = :username and u.status = 1";
        Query query = sessionFactory.getCurrentSession().createQuery(hql,model.getClass());
        query.setParameter("username", model.getUsername());
        UserInterface user = new User();
        try {
            user = (UserInterface) query.getSingleResult();
        }
        catch (NoResultException e){
            System.out.println(query.toString());
            System.out.println(e.getMessage());
            System.out.print(e.getStackTrace());
        }
        return user;
    }

    @Override
    @Transactional
    public ModelInterface findById(Integer id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    @Override
    @Transactional
    public List<ModelInterface> findAll(ModelInterface model) {
        return sessionFactory.getCurrentSession().createQuery("select m from User m").getResultList();
    }

}
