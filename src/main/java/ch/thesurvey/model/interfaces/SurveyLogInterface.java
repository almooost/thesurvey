package ch.thesurvey.model.interfaces;


/**
 * Interface for survey logs
 * @author Samuel Alfano
 * @date 22.11.2016
 * @version v0.1
 */
public interface SurveyLogInterface {

    /**
     * Get id of survey log
     * @return
     */
    Integer getId();

    /**
     * Get questions for survey
     * @return questions
     */
    QuestionInterface getQuestion();

    /**
     * Set question for log
     * @param question
     */
    void setQuestion(QuestionInterface question);

    /**
     * get original question text
     * @return
     */
    String getQuestionText();

    /**
     * Set original question text
     * @param questionText
     */
    void setQuestionText(String questionText);

    /**
     * Get survey from log entry
     * @return
     */
    SurveyInterface getSurvey();

    /**
     * Set survey for log
     * @param survey
     */
    void setSurvey(SurveyInterface survey);

    /**
     * Get filled out answer
     * @return answer
     */
    String getAnswer();

    /**
     * Set user filled answer
     * @param answer
     */
    void setAnswer(String answer);

    /**
     * Get reached point value
     * @return
     */
    Integer getPoints();

    /**
     * Set new point value
     * @param points
     */
    void setPoints(Integer points);


}
