package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.AnswerInterface;
import ch.thesurvey.model.interfaces.AnswerTypeInterface;
import javax.persistence.*;
import java.util.Date;

/**
 * Template for answer
 * @author Samuel Alfano
 * @date 25.11.2016
 * @version v0.2
 */
@Entity
@Table(name = "answer_templates")
public class AnswerTemplate implements AnswerInterface {

    private Integer id;
    private String name;
    private String description;
    private String type;
    private Integer status;
    private String answer;

    private AnswerTypeInterface answerType;

    private Integer points;
    private Date datetime;

    public AnswerTemplate(){
        answerType = new MultipleChoice();
    }

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
    public String getAnswer() {return answer;}

    public void setAnswer(String answer){
        answerType.fromJson(answer);
        this.answer = answer;
    }

    @Transient
    public AnswerTypeInterface getAnswerType(){return answerType;}

    public void setAnswerType(AnswerTypeInterface answerType){
        this.answerType = answerType;
        this.answer = answerType.getJson();
    }

}
