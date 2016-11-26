package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.QuestionInterface;
import ch.thesurvey.model.interfaces.SurveyContactInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;
import ch.thesurvey.model.interfaces.SurveyQuestionInterface;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Create relationship between surveys and questions
 * @author Samuel Alfano
 * @date 21.11.2016
 * @version v0.2
 */
@Entity
@Table(name = "survey_question")
public class SurveyQuestion implements SurveyQuestionInterface, Serializable {

    private Integer id;
    private SurveyInterface survey;
    private QuestionInterface question;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Survey.class)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    public SurveyInterface getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyInterface survey) {
        this.survey = survey;
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Question.class)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    public QuestionInterface getQuestion() {
        return question;
    }

    public void setQuestion(QuestionInterface question) {
        this.question = question;
    }

    @Override
    @Transient
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) { }

    @Override
    @Transient
    public Integer getStatus() {
        return null;
    }

    @Override
    public void setStatus(Integer status) {}

    @Override
    @Transient
    public Date getTimestamp() {
        return null;
    }

    @Override
    public void setTimestamp(Date datetime) {}


}
