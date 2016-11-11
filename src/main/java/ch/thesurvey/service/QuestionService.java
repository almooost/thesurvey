package ch.thesurvey.service;

import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.persistence.dao.interfaces.QuestionDaoInterface;
import ch.thesurvey.service.interfaces.QuestionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for abstracting question dao
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
@Service
public class QuestionService implements QuestionServiceInterface {

    @Autowired
    private QuestionDaoInterface dao;

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
        dao.save(model);
    }

    @Transactional
    public void remove(ModelInterface model) {
        dao.remove(model);
    }
}
