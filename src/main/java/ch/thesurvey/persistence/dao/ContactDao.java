package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.Contact;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.persistence.dao.interfaces.ContactDaoInterface;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Object for accessing the database
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
@Repository
public class ContactDao extends AbstractDao implements ContactDaoInterface{

    @Override
    @Transactional
    public ModelInterface findById(Integer id) {
        return sessionFactory.getCurrentSession().find(Contact.class, id);
    }

    @Override
    @Transactional
    public List<ModelInterface> findAll(ModelInterface model) {
        return sessionFactory.getCurrentSession().createQuery("select m from Contact m").getResultList();
    }
}
