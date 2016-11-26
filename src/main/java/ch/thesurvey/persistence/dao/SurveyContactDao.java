package ch.thesurvey.persistence.dao;

import ch.thesurvey.model.Question;
import ch.thesurvey.model.SurveyContact;
import ch.thesurvey.model.SurveyLog;
import ch.thesurvey.model.User;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.SurveyContactInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;
import ch.thesurvey.model.interfaces.UserInterface;
import ch.thesurvey.persistence.dao.interfaces.SurveyContactDaoInterface;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Data access object for handling db values for persistence
 * @author Samuel Alfano
 * @version v0.1
 */
@Repository
public class SurveyContactDao extends AbstractDao implements SurveyContactDaoInterface {

    @Override
    @Transactional
    public ModelInterface findById(Integer id) {
        return sessionFactory.getCurrentSession().find(SurveyContact.class, id);
    }

    @Override
    @Transactional
    public List<ModelInterface> findAll(ModelInterface model) {
        return sessionFactory.getCurrentSession().createQuery("select m from SurveyContact m").getResultList();
    }

    /**
     * Find a surveyContact by token
     * @param model
     * @return
     */
    @Transactional
    public SurveyContactInterface findByToken(SurveyContactInterface model){
        String hql = "from SurveyContact m where m.token = :token and m.tokenUntil > NOW()";
        Query query = sessionFactory.getCurrentSession().createQuery(hql,model.getClass());
        query.setParameter("token", model.getToken());
        SurveyContactInterface surveyContact = new SurveyContact();
        try {
            surveyContact = (SurveyContactInterface) query.getSingleResult();
        }
        catch (NoResultException e){
            System.out.println(query.toString());
            System.out.println(e.getMessage());
            System.out.print(e.getStackTrace());
        }
        return surveyContact;
    }

    /**
     * Find a surveyContact by survey
     * @param model
     * @return
     */
    @Transactional
    public List<SurveyContactInterface> findBySurvey(ModelInterface model){

        String hql = "from SurveyContact m where m.id = :survey_id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql,SurveyContact.class);
        query.setParameter("survey_id", model.getId());
        List<SurveyContactInterface> surveyContacts = null;
        try {
            surveyContacts = query.getResultList();
        }
        catch (NoResultException e){
            System.out.println(query.toString());
            System.out.println(e.getMessage());
            System.out.print(e.getStackTrace());
        }
        return surveyContacts;
    }

}
