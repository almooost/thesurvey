package ch.thesurvey.service;

import ch.thesurvey.AbstractTest;
import ch.thesurvey.model.Answer;
import ch.thesurvey.model.MultipleChoice;
import ch.thesurvey.model.Question;
import ch.thesurvey.model.interfaces.AnswerInterface;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.QuestionInterface;
import ch.thesurvey.service.interfaces.QuestionServiceInterface;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Test if DB Connection via QuestionService works
 * @author Samuel Alfano
 * @version v0.1
 */
@Transactional
public class QuestionServiceTest extends AbstractTest {

    @Autowired
    private QuestionServiceInterface questionService;

    private QuestionInterface question;

    @Before
    public void setUp(){
        question = new Question();
    }

    @After
    public void tearDown(){
        question = null;
    }

    @Test
    public void findAllTest(){
        List<ModelInterface> questionList = questionService.findAll(new Question());

        Assert.assertNotNull("failure - expected not null", questionList);
        boolean hasElements = questionList.size() >= 1 ? true : false;

        Assert.assertEquals("failure - expected size 1", true, hasElements);
    }

    @Test
    public void persistTest(){
        question.setType("Multiple-Choice");
        question.setName("Multiple Choice Ja/Nein");
        question.setStatus(1);
        question.setDescription("Unit Test Description");

        try{
            question.setTimestamp(SimpleDateFormat.getDateInstance().parse("24.12.2016"));
        }catch (Exception e){
            logger.debug("QuestionTest faild on persistTest - could not parse date");
        }

        AnswerInterface answer = new Answer();
        answer.setId(1);
        answer.setAnswerType(new MultipleChoice());
        answer.setAnswer(answer.getAnswerType().getJson());
        answer.setPoints(10);
        answer.setName("Unit Test Name");
        answer.setDescription("Unit Test Description");

        question.setAnswer(answer);

        questionService.persist(question);
        boolean success = question.getId() != null;
        Assert.assertEquals("Question could be persisted", true, success);
    }

    @Test
    public void removeTest(){

        List<ModelInterface> questionList = questionService.findAll(new Question());

        question = (QuestionInterface) questionList.get(0);

        Integer questionId = question.getId();

        questionService.remove(question);

        ModelInterface removedQuestion = questionService.findById(questionId);

        boolean removed = removedQuestion == null;

        Assert.assertEquals("Question removed sucessful",true, removed);

    }


}
