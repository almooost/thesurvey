package ch.thesurvey.controller;

import ch.thesurvey.model.Survey;
import ch.thesurvey.model.User;
import ch.thesurvey.service.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sam on 23.10.16.
 */
@Controller
public class SurveyController extends AbstractController{

    private Survey surveyList;
    private SurveyService surveyService;

    public SurveyController(){
        surveyList = new Survey();
    }

    @RequestMapping("/surveys")
    public ModelAndView getSurvey(@RequestParam(value = "survey", required = false, defaultValue = "none")String survey, ModelAndView model){
        return new ModelAndView("survey","user", new User(survey));
    }

    @RequestMapping(value = "/surveys/add", method = RequestMethod.POST)
    public String getSurveyName(@ModelAttribute Survey survey, ModelMap model){
        surveyList.addSurvey(survey);
        model.addAttribute("id", survey.getId());
        model.addAttribute("name", survey.getName());
        model.addAttribute("surveys", surveyList.getSurveys());
        return "survey";
    }
}
