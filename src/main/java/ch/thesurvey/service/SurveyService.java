package ch.thesurvey.service;

import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.persistence.dao.interfaces.SurveyDaoInterface;
import ch.thesurvey.service.interfaces.SurveyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for abstracting survey dao
 * @author Samuel Alfano
 * @version v0.1
 */
@Service
public class SurveyService implements SurveyServiceInterface{

    @Autowired
    private SurveyDaoInterface dao;

    @Transactional
    public ModelInterface findById(Integer id) {
        return dao.findById(id);
    }

    @Transactional
    public List<ModelInterface> findAll(ModelInterface model) {
        return dao.findAll(model);
    }

    @Transactional
    public void persist(ModelInterface model) {
        dao.persist(model);
    }

    @Transactional
    public void remove(ModelInterface model) {
        dao.remove(model);
    }
}
