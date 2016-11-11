package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.AnswerInterface;
import ch.thesurvey.model.interfaces.QuestionInterface;

import javax.persistence.*;
import java.util.Date;

/**
 * Model represents a question in a survey
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
@Entity
@Table(name = "question")
public class Question implements QuestionInterface{

    private Integer id;
    private String name;
    private String description;
    private String type;
    private Integer status;

    private Integer points;
    private Date datetime;

    private AnswerInterface answer;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "tstamp")
    public Date getTimestamp() {
        return datetime;
    }

    public void setTimestamp(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public void setAnswer(AnswerInterface answer) {
        this.answer = answer;
    }

}
