package ch.thesurvey.service;

import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.SurveyContactInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;
import ch.thesurvey.persistence.dao.interfaces.SurveyContactDaoInterface;
import ch.thesurvey.service.interfaces.SurveyContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for handling databases
 * @author Samuel Alfano
 * @version v0.1
 */
@Service
public class SurveyContactService implements SurveyContactServiceInterface {

    @Autowired
    private SurveyContactDaoInterface surveyContactDao;

    @Override
    public ModelInterface findById(Integer id) {
        return surveyContactDao.findById(id);
    }

    @Override
    public List<ModelInterface> findAll(ModelInterface model) {
        return surveyContactDao.findAll(model);
    }

    @Override
    public void persist(ModelInterface model) {
        surveyContactDao.persist(model);
    }

    @Override
    public void remove(ModelInterface model) {
        surveyContactDao.remove(model);
    }

    public List<SurveyContactInterface> findBySurvey(ModelInterface survey){
        return surveyContactDao.findBySurvey(survey);
    }

    @Override
    public SurveyContactInterface findByToken(SurveyContactInterface surveyContact) {
        return surveyContactDao.findByToken(surveyContact);
    }
}
