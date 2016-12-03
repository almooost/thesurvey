package ch.thesurvey.model.interfaces;

import java.util.Map;

/**
 * Interface for answer type generalization
 * @author Samuel Alfano
 * @date 27.11.2016
 * @version v0.1
 */
public interface AnswerTypeInterface {


    /**
     * Get name of answer type
     * @return
     */
    String getName();

    /**
     * Get coresponding values of answer type
     * @return
     */
    Map<String,String> getValues();

    /**
     * Get json string form object
     * @return
     */
    String getJson();

    /**
     * convert json string to map object
     * @param json
     */
    void fromJson(String json);
}
