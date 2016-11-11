package ch.thesurvey.model.interfaces;

import java.util.Date;
import java.util.List;

/**
 * Baisc survey type, extends ModelInterface
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
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
     * Get list of contact recipients
     * @return contacts
     */
    List<ContactInterface> getContacts();

    /**
     * Set new list of contacts
     * @param contacts
     */
    void setContacts(List<ContactInterface> contacts);

    /**
     * Add new contact to list of existing
     * @param contact
     */
    void addContact(ContactInterface contact);

    /**
     * Get list of questions
     * @return questions
     */
    List<QuestionInterface> getQuestions();

    /**
     * Set new list of questions
     * @param questions
     */
    void setQuestions(List<QuestionInterface> questions);

    /**
     * Add single question to survey
     * @param question
     */
    void addQuestion(QuestionInterface question);

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
