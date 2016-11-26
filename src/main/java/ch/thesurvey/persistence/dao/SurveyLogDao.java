package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.SurveyLog;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.SurveyLogInterface;
import ch.thesurvey.persistence.dao.interfaces.SurveyLogDaoInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Data access object for survey logs
 * @author Samuel Alfano
 * @date 22.11.2016
 * @version v0.1
 */
@Repository
public class SurveyLogDao implements SurveyLogDaoInterface {

    @Autowired
    protected SessionFactory sessionFactory;

    @Transactional
    public SurveyLogInterface findById(Integer id) {
        return sessionFactory.getCurrentSession().find(SurveyLog.class, id);
    }

    @Transactional
    public List<SurveyLogInterface> findAll(SurveyLogInterface model) {
        return sessionFactory.getCurrentSession().createQuery("select m from SurveyLog m").getResultList();
    }

    @Transactional
    public void persist(SurveyLogInterface model) {

        if(model.getId() == null)
            sessionFactory.getCurrentSession().persist(model);
        else
            sessionFactory.getCurrentSession().update(model);
    }

    @Transactional
    public void remove(SurveyLogInterface model) {
        sessionFactory.getCurrentSession().delete(model);
    }
}
