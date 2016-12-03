package ch.thesurvey.service;

import ch.thesurvey.AbstractTest;
import ch.thesurvey.model.*;
import ch.thesurvey.model.interfaces.AnswerInterface;
import ch.thesurvey.model.interfaces.QuestionInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;
import ch.thesurvey.model.interfaces.SurveyLogInterface;
import ch.thesurvey.service.interfaces.SurveyLogServiceInterface;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Test if DB Connection via SurveyLogService works
 * @author Samuel Alfano
 * @version v0.1
 */
@Transactional
public class SurveyLogServiceTest extends AbstractTest {

    @Autowired
    private SurveyLogServiceInterface surveyLogService;

    private SurveyLogInterface surveyLog;

    @Before
    public void setUp(){
        surveyLog = new SurveyLog();
    }

    @After
    public void tearDown(){
        surveyLog = null;
    }

    @Test
    public void findAllTest(){
        List<SurveyLogInterface> surveyLogList = surveyLogService.findAll(new SurveyLog());

        Assert.assertNotNull("failure - expected not null", surveyLogList);
        boolean hasElements = surveyLogList.size() >= 1 ;

        Assert.assertEquals("failure - expected size 1", true, hasElements);
    }

    @Test
    public void persistTest(){
        QuestionInterface question = new Question();
        question.setId(1);
        question.setName("Unit Test Question");
        question.setDescription("Unit Test Description");

        AnswerInterface answer = new Answer();
        answer.setId(1);
        answer.setAnswerType(new MultipleChoice());
        answer.setType("Multiple-Choice");
        answer.setAnswer(answer.getAnswerType().getJson());
        answer.setPoints(10);
        answer.setName("Unit Test Name");
        answer.setDescription("Unit Test Description");
        question.setAnswer(answer);

        SurveyInterface survey = new Survey();
        survey.setId(1);
        survey.setName("Unit Test Survey");
        survey.setDescription("Unit Test Description");

        try{
            survey.setStartDate(SimpleDateFormat.getDateInstance().parse("24.12.2016"));
            survey.setEndDate(SimpleDateFormat.getDateInstance().parse("25.12.2016"));
        }catch (Exception e){
            logger.debug("SurveyLogTest faild on persistTest - could not parse date");
        }

        surveyLog.setQuestion(question);
        surveyLog.setSurvey(survey);
        surveyLog.setAnswer("Unit Test Antwort");
        surveyLog.setPoints(7);

        surveyLogService.persist(surveyLog);
        boolean success = surveyLog.getId() != null;
        Assert.assertEquals("SurveyLog could be persisted", true, success);
    }

    @Test
    public void removeTest(){

        List<SurveyLogInterface> surveyLogList = surveyLogService.findAll(new SurveyLog());

        Assert.assertNotNull("SurveyLogList not null", surveyLogList);
        if(surveyLogList != null){
            surveyLog = surveyLogList.get(0);

            Integer surveyLogId = surveyLog.getId();

            surveyLogService.remove(surveyLog);

            SurveyLogInterface removedSurveyLog = surveyLogService.findById(surveyLogId);

            boolean removed = removedSurveyLog == null;

            Assert.assertEquals("SurveyLog removed sucessful",true, removed);
        }

    }
}
