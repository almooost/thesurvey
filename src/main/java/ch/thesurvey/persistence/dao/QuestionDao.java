package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.Question;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.persistence.dao.interfaces.QuestionDaoInterface;
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
public class QuestionDao extends AbstractDao implements QuestionDaoInterface{

    @Override
    @Transactional
    public ModelInterface findById(Integer id) {
        return sessionFactory.getCurrentSession().find(Question.class, id);
    }

    @Override
    @Transactional
    public List<ModelInterface> findAll(ModelInterface model) {
        return sessionFactory.getCurrentSession().createQuery("select m from Question m").getResultList();
    }
}
