package ch.thesurvey.model.interfaces;

/**
 * Basic type for survey evaluations
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v9,1
 */
public interface EvaluationInterface extends ModelInterface {

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


}
