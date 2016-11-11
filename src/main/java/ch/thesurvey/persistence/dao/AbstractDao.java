package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.persistence.dao.interfaces.DaoInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Abstract Object for accessing the database
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
@Repository
public abstract class AbstractDao implements DaoInterface {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void save(ModelInterface model) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        model.setId(null);
        session.persist(model);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void remove(ModelInterface model) {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        session.detach(model);
        session.getTransaction().commit();
        session.close();
    }
}
