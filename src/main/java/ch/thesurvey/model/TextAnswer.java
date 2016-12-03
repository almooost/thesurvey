package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.AnswerTypeInterface;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Representation of a textual anser
 * @author Samuel Alfano
 * @ate 27.11.2016
 * @version v0.1
 */
public class TextAnswer implements AnswerTypeInterface{

    private String name;

    private Map<String,String> values;

    public String getName(){return name;}

    public Map<String,String> getValues(){return values;}


    public TextAnswer(){
        prepareDefault();
    }

    private void prepareDefault(){
        name = "Geben Sie ihre persönliche Antwort ein.";

        values = new HashMap<String, String>();
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
