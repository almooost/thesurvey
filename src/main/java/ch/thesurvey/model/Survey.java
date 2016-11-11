package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.ContactInterface;
import ch.thesurvey.model.interfaces.EvaluationInterface;
import ch.thesurvey.model.interfaces.QuestionInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Model for Survey, handles all survey relevant objects
 * @author Samuel Alfano
 * @date 11.11.2016
 * @version v0.1
 */
@Entity
@Table(name="survey")
public class Survey implements SurveyInterface {

    private Integer id;
    private String name;
    private String description;
    private String author;
    private Date start_date;
    private Date end_date;
    private Integer status;

    private Integer points;
    private Date datetime;

    private List<ContactInterface> contacts;
    private List<QuestionInterface> questions;
    private EvaluationInterface evaluations;

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
    @Column(name="description")
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    @Column(name = "date_start")
    public Date getStartDate() {
        return start_date;
    }

    @Override
    public void setStartDate(Date date) {
        this.start_date = date;
    }

    @Override
    @Column(name = "date_end")
    public Date getEndDate() {
        return end_date;
    }

    @Override
    public void setEndDate(Date date) {
        this.end_date = date;
    }

    @Override
    @Column(name="status")
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name="points")
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Column(name="tstamp")
    public Date getTimestamp() {
        return datetime;
    }

    public void setTimestamp(Date datetime) {
        this.datetime = datetime;
    }

    @Transient
    public List<ContactInterface> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactInterface> contacts) {
        this.contacts = contacts;
    }

    public void addContact(ContactInterface contact){
        contacts.add(contact);
    }

    @Override
    @Transient
    public List<QuestionInterface> getQuestions() {
        return questions;
    }

    @Override
    public void setQuestions(List<QuestionInterface> questions) {
        this.questions = questions;
    }

    @Override
    public void addQuestion(QuestionInterface question) {
        this.questions.add(question);
    }

    @Override
    @Transient
    public EvaluationInterface getEvaluation() {
        return evaluations;
    }

    @Override
    public void setEvaluation(EvaluationInterface evaluation) {
        this.evaluations = evaluation;
    }
}
