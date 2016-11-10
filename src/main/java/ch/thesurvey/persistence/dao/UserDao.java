package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.User;
import ch.thesurvey.model.interfaces.IUser;
import ch.thesurvey.persistence.dao.interfaces.IUserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sam on 23.10.16.
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public IUser findByUser(IUser model) {

        String hql = "from User u where u.username = :username and u.status = 1";
        Query query = sessionFactory.getCurrentSession().createQuery(hql,model.getClass());
        query.setParameter("username", model.getUsername());
        IUser user = new User();
        try {
            user = (IUser) query.getSingleResult();
        }
        catch (NoResultException e){
            System.out.println(query.toString());
            System.out.println(e.getMessage());
            System.out.print(e.getStackTrace());
        }
        return user;
    }

    @Override
    public IUser findById(Integer userId) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        IUser resultUser = session.find(User.class, userId);
        session.getTransaction().commit();
        session.close();
        return resultUser;
    }

    @Override
    public List<IUser> findAll(IUser model) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        List<IUser> models = session.createQuery("select m from User m").getResultList();

        session.getTransaction().commit();
        session.close();
        return models;
    }

    @Override
    public void save(IUser model) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        model.setId(null);
        session.persist(model);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void remove(IUser model) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        session.detach(model);
        session.getTransaction().commit();
        session.close();
    }

}
