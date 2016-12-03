package ch.thesurvey.service;

import ch.thesurvey.AbstractTest;
import ch.thesurvey.model.*;
import ch.thesurvey.model.interfaces.*;
import ch.thesurvey.service.interfaces.SurveyContactServiceInterface;
import ch.thesurvey.service.interfaces.SurveyQuestionServiceInterface;
import ch.thesurvey.service.interfaces.SurveyServiceInterface;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Test if DB Connection via SurveyService works
 * @author Samuel Alfano
 * @version v0.1
 */
@Transactional
public class SurveyServiceTest extends AbstractTest {

    @Autowired
    private SurveyServiceInterface surveyService;

    private SurveyInterface survey;

    @Before
    public void setUp(){

        survey = new Survey();
    }

    @After
    public void tearDown(){
        survey = null;
    }

    @Test
    public void findAllTest(){
        List<ModelInterface> surveyList = surveyService.findAll(new Survey());

        Assert.assertNotNull("failure - expected not null", surveyList);
        boolean hasElements = surveyList.size() >= 1 ? true : false;

        Assert.assertEquals("failure - expected size 1", true, hasElements);
    }

    @Test
    public void persistTest(){
        survey.setName("Unit Test Survey Name");
        survey.setStatus(1);
        survey.setDescription("Unit Test Survey Description");
        survey.setAuthor("Hans Muster");
        try{
            survey.setStartDate(SimpleDateFormat.getDateInstance().parse("24.12.2016"));
            survey.setEndDate(SimpleDateFormat.getDateInstance().parse("25.12.2016"));
        }catch (Exception e){
            logger.debug("SurveyTest failed - could not parse date");
        }

        ContactInterface contact = new Contact();
        contact.setName("Muster");
        contact.setGivenname("Hans");
        contact.setDepartment("Testing");
        contact.setId(1);
        contact.setEmail("hans.muster@trash-mail.com");
        contact.setStatus(1);

        SurveyContact surveyContact = new SurveyContact();
        surveyContact.setContact(contact);
        surveyContact.setName("UNIT TEST");
        surveyContact.setId(1);

        List<SurveyContactInterface> surveyContactList = new ArrayList<SurveyContactInterface>();
        surveyContactList.add(surveyContact);
        survey.setSurveyContacts(surveyContactList);

        QuestionInterface question = new Question();
        question.setType(MultipleChoice.class.toString());
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

        SurveyQuestionInterface surveyQuestion = new SurveyQuestion();
        surveyQuestion.setQuestion(question);
        surveyQuestion.setName("UNIT TESt");
        surveyQuestion.setId(1);
        List<SurveyQuestionInterface> surveyQuestionList = new ArrayList<SurveyQuestionInterface>();
        surveyQuestionList.add(surveyQuestion);
        survey.setSurveyQuestions(surveyQuestionList);

        surveyService.persist(survey);
        boolean success = survey.getId() != null;
        Assert.assertEquals("Survey could be persisted", true, success);
    }

    @Test
    public void removeTest(){

        List<ModelInterface> surveyList = surveyService.findAll(new Survey());

        survey = (SurveyInterface) surveyList.get(0);

        Integer surveyId = survey.getId();

        surveyService.remove(survey);

        ModelInterface removedSurvey = surveyService.findById(surveyId);

        boolean removed = removedSurvey == null;

        Assert.assertEquals("Survey removed sucessful",true, removed);

    }

}
