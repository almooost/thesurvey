package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.AnswerTypeInterface;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Java representation of a multiple choice question
 * @author Samuel Alfano
 * @date 27.11.2016
 * @version v01.
 */
public class MultipleChoice implements AnswerTypeInterface{

    private String name;

    private Map<String,String> values;

    public String getName(){return name;}

    public Map<String,String> getValues(){return values;}


    public MultipleChoice(){
        prepareDefault();
    }

    private void prepareDefault(){
        name = "Bewertung auf einer Skala von 1 - 5 (ungenügend - sehr gut)";

        values = new HashMap<String,String>();
        values.put("sehr gut", "5");
        values.put("gut", "4");
        values.put("genügend", "3");
        values.put("schlecht", "2");
        values.put("ungenügend", "1");
    }

    public String getJson(){

        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(getValues());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public void fromJson(String json){
        if(json != null){
            ObjectMapper mapper = new ObjectMapper();

            Map<String, String> map = new HashMap<String, String>();

            try{
                values = mapper.readValue(json,
                        new TypeReference<HashMap<String, String>>() {
                        });
            }
            catch (IOException e) {
                e.printStackTrace();
                ;

            }
        }
    }
}
