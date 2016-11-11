package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.Survey;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.persistence.dao.interfaces.SurveyDaoInterface;
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
public class SurveyDao extends AbstractDao implements SurveyDaoInterface {

    @Override
    @Transactional
    public ModelInterface findById(Integer id) {
        return sessionFactory.getCurrentSession().find(Survey.class, id);
    }

    @Override
    @Transactional
    public List<ModelInterface> findAll(ModelInterface model) {
        return sessionFactory.getCurrentSession().createQuery("select m from Survey m").getResultList();
    }
}
