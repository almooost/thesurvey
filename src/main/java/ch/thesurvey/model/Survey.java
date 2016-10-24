package ch.thesurvey.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sam on 23.10.16.
 */
public class Survey {

    private Integer id;
    private String name;

    private List<Survey> surveys;

    public Survey(){
        this.surveys = new ArrayList<Survey>();
    }

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addSurvey(Survey survey){
        surveys.add(survey);
    }

    public List<Survey> getSurveys(){
        return this.surveys;
    }
}
