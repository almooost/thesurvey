package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.EvaluationInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;

import javax.persistence.*;
import java.util.Date;

/**
 * Model for evaluation details about a survy
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.2
 */
@Entity
@Table(name = "evaluation")
public class Evaluation implements EvaluationInterface {

    private Integer id;
    private String name;
    private String description;
    private String type;
    private Integer status;
    private SurveyInterface survey;

    private Date datetime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "timestamp")
    public Date getTimestamp() {
        return datetime;
    }

    public void setTimestamp(Date datetime) {
        this.datetime = datetime;
    }

}
