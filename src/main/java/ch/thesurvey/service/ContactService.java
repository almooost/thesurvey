package ch.thesurvey.service;

import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.persistence.dao.interfaces.ContactDaoInterface;
import ch.thesurvey.service.interfaces.ContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for abstracting contact dao
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
@Service
public class ContactService implements ContactServiceInterface{

    @Autowired
    private ContactDaoInterface dao;

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
