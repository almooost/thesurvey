package ch.thesurvey.model.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Basic type for answers
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
public interface AnswerInterface extends ModelInterface{

    /**
     * Get reached points for answer
     * @return points
     */
    Integer getPoints();

    /**
     * Set new points for answer
     * @param points
     */
    void setPoints(Integer points);

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
     * Get answers
     * @return answers
     */
    String getAnswers();

    /**
     * Set answers
     * @param answers
     */
    void setAnswers(String answers);

    /**
     * Map of answers
     * @return
     */
    Map getAnswerList();
}
