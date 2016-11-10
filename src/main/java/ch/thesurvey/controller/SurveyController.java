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
 * Servey paths for surveys
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class SurveyController {

    private Survey surveyList;
    private SurveyService surveyService;

    public SurveyController(){
        surveyList = new Survey();
    }

    /*
     Example ModelAndView
    @RequestMapping("/surveys")
    public ModelAndView getSurvey(@RequestParam(value = "survey", required = false, defaultValue = "none")String survey, ModelAndView model){
        return new ModelAndView("index","user", new User(survey));
    }
     */

    @RequestMapping("/surveys")
    public String getSurvey(@RequestParam(value = "survey", required = false, defaultValue = "none")String survey, ModelMap model){
        model.addAttribute("site","survey");
        model.addAttribute("action", "manage");
        return "index";
    }

    @RequestMapping(value = "/surveys/add", method = RequestMethod.POST)
    public String getSurveyName(@ModelAttribute Survey survey, ModelMap model){
        surveyList.addSurvey(survey);
        model.addAttribute("site", "surveys");
        model.addAttribute("id", survey.getId());
        model.addAttribute("name", survey.getName());
        model.addAttribute("surveys", surveyList.getSurveys());
        return "index";
    }
}
