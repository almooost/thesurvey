package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.persistence.dao.interfaces.DaoInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void persist(ModelInterface model) {

        if(model.getId() == null)
            sessionFactory.getCurrentSession().persist(model);
        else
            sessionFactory.getCurrentSession().update(model);
    }

    @Transactional
    public void remove(ModelInterface model) {
        sessionFactory.getCurrentSession().delete(model);
    }
}
