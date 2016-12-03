package ch.thesurvey.model.interfaces;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

/**
 * Baisc survey type, extends ModelInterface
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.2
 */
public interface SurveyInterface extends ModelInterface {

    /**
     * Get start date of survey
     * @return
     */
    Date getStartDate();

    /**
     * Set new start date of survey
     * @param date
     */
    void setStartDate(Date date);

    /**
     * Get current author for survey
     * @return
     */
    String getAuthor();

    /**
     * Set new author for survey
     * @param author
     */
    void setAuthor(String author);

    /**
     * Get enddate of survey
     * @return
     */
    Date getEndDate();

    /**
     * Set end date of survey
     * @param date
     */
    void setEndDate(Date date);

    /**
     * Get list of contacts for this survey
     * @return
     */
    List<SurveyContactInterface> getSurveyContacts();

    /**
     * Set new list of survey contacts
     * @param surveyContacts
     */
    void setSurveyContacts(List<SurveyContactInterface> surveyContacts);

    /**
     * Add a new surveyContact
     * @param surveyContact
     */
    void addSurveyContact(SurveyContactInterface surveyContact);

    /**
     * Get list of questions
     * @return surveyQuestion
     */
    List<SurveyQuestionInterface> getSurveyQuestions();

    /**
     * Set new list of questions
     * @param surveyQuestions
     */
    void setSurveyQuestions(List<SurveyQuestionInterface> surveyQuestions);

    /**
     * Add single question to survey
     * @param question
     */
    void addSurveyQuestion(SurveyQuestionInterface question);

    /**
     * Get evaluation for survey
     * @return evaluation
     */
    EvaluationInterface getEvaluation();

    /**
     * Set new evaluation for survey
     * @param evaluation
     */
    void setEvaluation(EvaluationInterface evaluation);

    /**
     * Description of answer object
     * @return description
     */
    String getDescription();

    /**
     * Set new description
     * @param description
     */
    void setDescription(String description);

}
