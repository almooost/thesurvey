package ch.thesurvey.service;

import ch.thesurvey.AbstractTest;
import ch.thesurvey.model.Answer;
import ch.thesurvey.model.MultipleChoice;
import ch.thesurvey.model.interfaces.AnswerInterface;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.service.interfaces.AnswerServiceInterface;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Test if DB Connection via AnswerService works
 * @author Samuel Alfano
 * @version v0.1
 */
@Transactional
public class AnswerServiceTest extends AbstractTest {

    @Autowired
    private AnswerServiceInterface answerService;

    private AnswerInterface answer;

    @Before
    public void setUp(){
        answer = new Answer();
    }

    @After
    public void tearDown(){
        answer = null;
    }

    @Test
    public void findAllTest(){
        List<ModelInterface> answerList = answerService.findAll(new Answer());

        Assert.assertNotNull("failure - expected not null", answerList);
        boolean hasElements = answerList.size() >= 1 ? true : false;

        Assert.assertEquals("failure - expected size 1", true, hasElements);
    }

    @Test
    public void persistTest(){

        answer.setAnswerType(new MultipleChoice());
        answer.setType("Multiple-Choice");
        answer.setAnswer(answer.getAnswerType().getJson());
        answer.setName("Multiple Choice Ja/Nein");
        answer.setStatus(1);
        answer.setDescription("Unit Test Description");
        answer.setPoints(10);

        try{
            answer.setTimestamp(SimpleDateFormat.getDateInstance().parse("24.12.2016"));
        }catch (Exception e){
            logger.debug("AnswerTest faild on persistTest - could not parse date");
        }

        answerService.persist(answer);
        boolean success = answer.getId() != null;
        Assert.assertEquals("Answer could be persisted", true, success);
    }

    @Test
    public void removeTest(){

        List<ModelInterface> answerList = answerService.findAll(new Answer());

        answer = (AnswerInterface) answerList.get(0);

        Integer answerId = answer.getId();

        logger.debug("Answer id"+answerId);

        answerService.remove(answer);

        ModelInterface removedAnswer = answerService.findById(answerId);

        boolean removed = removedAnswer == null;

        Assert.assertEquals("Answer removed sucessful",true, removed);

    }
}
