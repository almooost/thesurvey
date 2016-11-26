package ch.thesurvey.service.interfaces;

import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.SurveyContactInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;

import java.util.List;

/**
 * Type for customer services
 * @author Samuel Alfano
 * @date 19.11.2016
 * @version v0.1
 */
public interface SurveyContactServiceInterface extends ServiceInterface {

    SurveyContactInterface findByToken(SurveyContactInterface surveyContact);

    List<SurveyContactInterface> findBySurvey(ModelInterface survey);
}
