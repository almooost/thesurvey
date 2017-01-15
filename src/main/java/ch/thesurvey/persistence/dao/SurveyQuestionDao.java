package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.SurveyQuestion;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.persistence.dao.interfaces.SurveyQuestionDaoInterface;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Data access object for handling db values for persistence
 * @author Samuel Alfano
 * @version v0.1
 */
@Repository
public class SurveyQuestionDao extends AbstractDao implements SurveyQuestionDaoInterface{

    @Override
    @Transactional(readOnly = true)
    public ModelInterface findById(Integer id) {
        return sessionFactory.getCurrentSession().find(SurveyQuestion.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ModelInterface> findAll(ModelInterface model) {
        return sessionFactory.getCurrentSession().createQuery("select m from SurveyQuestion m").getResultList();
    }

}
