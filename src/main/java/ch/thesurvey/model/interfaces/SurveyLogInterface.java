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


}
