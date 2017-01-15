package ch.thesurvey.persistence.dao.interfaces;

import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.SurveyContactInterface;

import java.util.List;

/**
 * Interface for survey contact many to many table
 * @author Samuel Alfano
 * @date 23.11.2016
 * @version v0.2
 */
public interface SurveyContactDaoInterface extends DaoInterface {

    /**
     * Find a surveyContact by token
     * @param model
     * @return
     */
    SurveyContactInterface findByToken(SurveyContactInterface model);

    /**
     * Find a surveyContact by survey
     * @param model
     * @return
     */
    List<SurveyContactInterface> findBySurvey(ModelInterface model);
}
