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

    private Integer answerId;
    private Date datetime;

    private AnswerInterface answer;

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

    @Column(name = "tstamp")
    public Date getTimestamp() {
        return datetime;
    }

    public void setTimestamp(Date datetime) {
        this.datetime = datetime;
    }

    @OneToOne(targetEntity = Answer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "answer_id", referencedColumnName = "id", updatable = false, insertable = false)
    public AnswerInterface getAnswer(){return answer;}

    public void setAnswer(AnswerInterface answer) {this.answer = answer;}

}
