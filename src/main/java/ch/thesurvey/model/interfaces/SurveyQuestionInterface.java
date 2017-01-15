package ch.thesurvey.model.interfaces;

/**
 * Interface for making a relationship between surveys and questions
 * @author Samuel Alfano
 * @date 21.11.2016
 * @versio v0.2
 */
public interface SurveyQuestionInterface extends ModelInterface {

    /**
     * Get current survey id
     * @return surveyid
     */
    SurveyInterface getSurvey();

    /**
     * Set new survey id
     * @param surveyId
     */
    void setSurvey(SurveyInterface surveyId);

    /**
     * Get current question
     * @return questionId
     */
    QuestionInterface getQuestion();

    /**
     * Set new id of a question
     * @param question
     */
    void setQuestion(QuestionInterface question);
}
