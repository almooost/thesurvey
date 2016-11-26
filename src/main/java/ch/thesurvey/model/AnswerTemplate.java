package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.AnswerInterface;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Template for answer
 * @author Samuel Alfano
 * @date 25.11.2016
 * @version v0.1
 */
@Entity
@Table(name = "answer_templates")
public class AnswerTemplate implements AnswerInterface {

    private Integer id;
    private String name;
    private String description;
    private String type;
    private Integer status;

    private String answers;

    private Integer points;
    private Date datetime;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    @Column(name = "type")
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    @Column(name = "points")
    public Integer getPoints() {
        return points;
    }

    @Override
    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    @Column(name = "timestamp")
    public Date getTimestamp() {
        return datetime;
    }

    @Override
    public void setTimestamp(Date datetime) {
        this.datetime = datetime;
    }

    @Column(name = "answers")
    public String getAnswers() {return answers;}

    @Override
    public void setAnswers(String answers) {this.answers = answers;}

    @Transient
    public Map getAnswerList(){

        Map<String, Object> map = new HashMap<String, Object>();

        try {

            ObjectMapper mapper = new ObjectMapper();
            String json = getAnswers();

            // convert JSON string to Map
            map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});

            return map;

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return map;
        }
    }

}
