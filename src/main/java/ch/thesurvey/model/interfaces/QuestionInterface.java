package ch.thesurvey.model.interfaces;

/**
 * Basic type for questions
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
public interface QuestionInterface extends ModelInterface {

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

    /**
     * Type of answer object
     * @return type
     */
    String getType();

    /**
     * Set new type
     * @param type
     */
    void setType(String type);

    /**
     * Get corresponding answer to question
     * @return answer
     */
    AnswerInterface getAnswer();

    /**
     * Set new answer
     * @param answer
     */
    void setAnswer(AnswerInterface answer);
}
