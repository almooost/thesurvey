package ch.thesurvey.service;

import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.SurveyQuestionInterface;
import ch.thesurvey.persistence.dao.interfaces.SurveyContactDaoInterface;
import ch.thesurvey.persistence.dao.interfaces.SurveyQuestionDaoInterface;
import ch.thesurvey.service.interfaces.SurveyContactServiceInterface;
import ch.thesurvey.service.interfaces.SurveyQuestionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service layer for handling databases
 * @author Samuel Alfano
 * @version v0.1
 */
@Service
public class SurveyQuestionService implements SurveyQuestionServiceInterface {

    @Autowired
    private SurveyQuestionDaoInterface surveyQuestionDao;

    @Transactional
    public ModelInterface findById(Integer id) {
        return surveyQuestionDao.findById(id);
    }

    @Transactional
    public List<ModelInterface> findAll(ModelInterface model) {
        return surveyQuestionDao.findAll(model);
    }

    @Transactional
    public void persist(ModelInterface model) {
        surveyQuestionDao.persist(model);
    }

    @Transactional
    public void remove(ModelInterface model) {
        surveyQuestionDao.remove(model);
    }
}
