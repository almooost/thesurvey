package ch.thesurvey.controller;

import ch.thesurvey.model.Question;
import ch.thesurvey.model.SurveyContact;
import ch.thesurvey.model.SurveyLog;
import ch.thesurvey.model.interfaces.*;
import ch.thesurvey.service.interfaces.SurveyContactServiceInterface;
import ch.thesurvey.service.interfaces.SurveyLogServiceInterface;
import ch.thesurvey.service.interfaces.SurveyQuestionServiceInterface;
import ch.thesurvey.service.interfaces.SurveyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Handle survey fileld out by employees
 * @author Samuel Alfano
 * @date 22.11.2016
 * @version v0.1
 */
@Controller
@RequestMapping(value = "/live")
@PreAuthorize("hasRole('ROLE_ANONYMOUS')")
public class SurveyLogController {

    private List<ModelInterface> surveyList;

    @Autowired
    private SurveyServiceInterface surveyService;

    @Autowired
    private SurveyLogServiceInterface surveyLogService;

    @Autowired
    private SurveyQuestionServiceInterface surveyQuestionService;

    @Autowired
    private SurveyContactServiceInterface surveyContactService;

    public SurveyLogController(){
        surveyList = new ArrayList<ModelInterface>();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String live(@RequestParam(value = "id", required = true) String id,
                       @RequestParam(name = "token", required = true)String token,
                       ModelMap model,
                       HttpSession httpSession) {


        System.out.println("Reached live");

        if(!checkToken(token))
            return "redirect:/";

        SurveyInterface survey = (SurveyInterface)surveyService.findById(Integer.parseInt(id));
        if(survey == null)
            return "redirect:/";

        model = prepareRequest(httpSession, model, survey);
        httpSession.setAttribute("url", "/live/?id="+id+"&token="+token);

        model.addAttribute("survey", survey);
        model.addAttribute("site", "live");
        return "index";
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveSurvey(@ModelAttribute(name = "surveyLog")QuestionInterface question,
                             @RequestAttribute(name = "id", required = true)String id,
                             @RequestAttribute(name = "token", required = true)String token,
                             ModelMap model,
                             HttpSession httpSession){

        if(!checkToken(token))
            return "redirect:/";

        SurveyInterface survey = (SurveyInterface)surveyService.findById(Integer.parseInt(id));
        if(survey == null)
            return "redirect:/";

        SurveyLogInterface surveyLog = new SurveyLog();
        surveyLog.setSurvey(survey);
        surveyLog.setQuestion(question);

        surveyLogService.persist(surveyLog);

        model = prepareRequest(httpSession, model, survey);
        httpSession.setAttribute("url", "/live/?id="+id+"&token="+token);

        model.addAttribute("survey", survey);
        model.addAttribute("site", "live");
        return "index";

    }



    private boolean checkToken(String token){
        SurveyContactInterface surveyContact = new SurveyContact();
        surveyContact.setToken(token);

        if(token.matches("^[\\d\\w\\_\\-\\+\\.]+$")){
            surveyContact = surveyContactService.findByToken(surveyContact);
            return !(surveyContact.getToken() == null || surveyContact.getToken().compareTo(token) != 0);
        }
        return false;
    }

    private ModelMap prepareRequest(HttpSession httpSession, ModelMap model, SurveyInterface survey){

        httpSession.setAttribute("question_count", survey.getSurveyQuestions().size());

        boolean set_question = false;
        Integer current_question = null;

        if(httpSession.getAttribute("question_id") == null)
            set_question = true;
        else
            current_question = (Integer)httpSession.getAttribute("question_id");


        int question_count = 1;

        model.addAttribute("question", null);

        for (SurveyQuestionInterface surveyQuestion: survey.getSurveyQuestions()) {

            if(set_question){
                httpSession.setAttribute("question_id", surveyQuestion.getId());
                httpSession.setAttribute("question_count_index", question_count);
                model.addAttribute("question", surveyQuestion);
                break;
            }

            if(current_question == null || current_question.equals(surveyQuestion.getId()))
                set_question = true;
            question_count++;
        }

        return model;
    }

}
