package ch.thesurvey.service;

import ch.thesurvey.model.interfaces.SurveyLogInterface;
import ch.thesurvey.persistence.dao.interfaces.SurveyLogDaoInterface;
import ch.thesurvey.service.interfaces.SurveyLogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sam on 22.11.16.
 */
@Service
public class SurveyLogService implements SurveyLogServiceInterface {

    @Autowired
    private SurveyLogDaoInterface surveyLogDao;

    @Override
    public SurveyLogInterface findById(Integer id) {
        return surveyLogDao.findById(id);
    }

    @Override
    public List<SurveyLogInterface> findAll(SurveyLogInterface model) {
        return surveyLogDao.findAll(model);
    }

    @Override
    public void persist(SurveyLogInterface model) {
        surveyLogDao.persist(model);
    }

    @Override
    public void remove(SurveyLogInterface model) {
        surveyLogDao.remove(model);
    }
}
