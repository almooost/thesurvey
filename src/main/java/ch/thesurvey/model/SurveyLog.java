package ch.thesurvey.model;

import ch.thesurvey.model.interfaces.AnswerInterface;
import ch.thesurvey.model.interfaces.QuestionInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;
import ch.thesurvey.model.interfaces.SurveyLogInterface;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

/**
 * Class for storing a filled out survey
 * @author Samuel Alfano
 * @version v0.3
 */
@Entity
@Table(name = "survey_log")
public class SurveyLog implements SurveyLogInterface {

    private Integer id;
    private SurveyInterface survey;
    private QuestionInterface question;
    private String answer;
    private Integer points;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(targetEntity = Survey.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    public SurveyInterface getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyInterface survey) {
        this.survey = survey;
    }

    @OneToOne(targetEntity = Question.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    public QuestionInterface getQuestion() {return question; }

    public void setQuestion(QuestionInterface question) {
        this.question = question;
    }

    @Column(name = "question")
    public String getQuestionText(){return question.getDescription();}

    public void setQuestionText(String questionText){question.setDescription(questionText);}

    @Column(name = "answer")
    public String getAnswer() {return answer;}

    public void setAnswer(String answer) {this.answer = answer;}

    @Column(name = "points")
    public Integer getPoints(){return points;}

    public void setPoints(Integer points){this.points = points;}

}
