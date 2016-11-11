package ch.thesurvey.controller;

import ch.thesurvey.model.Survey;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;
import ch.thesurvey.service.SurveyService;
import ch.thesurvey.service.interfaces.SurveyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Servey paths for surveys
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class SurveyController {

    private List<ModelInterface> surveyList;
    @Autowired
    private SurveyServiceInterface surveyService;

    public SurveyController(){
        surveyList = new ArrayList<ModelInterface>();
    }

    @RequestMapping(value = "/surveys", method = RequestMethod.GET)
    public String getSurvey(@RequestParam(value = "action", required = false, defaultValue = "manage")String action,
                            ModelMap model,
                            HttpSession httpSession){

        switch (action){
            case "manage":
                surveyList = surveyService.findAll(new Survey());
                break;
            default:
                surveyList = surveyService.findAll(new Survey());
        }
        model.addAttribute("surveyList", surveyList);
        model.addAttribute("site","survey");
        return "index";
    }

    @RequestMapping(value = "/surveys/view", method = RequestMethod.GET)
    public String delteQuestion(@RequestParam(value = "id", required = false, defaultValue = "")String id,
                            ModelMap model,
                            HttpSession httpSession){

        ModelInterface survey = null;

        if(id.matches("^[\\d+]$")) {
            survey = surveyService.findById(Integer.parseInt(id));
        }

        model.addAttribute("survey", survey);
        model.addAttribute("site","survey_edit");
        return "index";
    }

    @RequestMapping(value = "/surveys/new", method = RequestMethod.GET)
    public String newSurvey(@RequestParam(value = "action", required = false, defaultValue = "new")String action,
                            ModelMap model,
                            HttpSession httpSession){

        model.addAttribute("username", "sam");
        model.addAttribute("site", "survey_new");
        return "index";
    }

    @RequestMapping(value = "/surveys/add", method = RequestMethod.POST)
    public String addSurvey(@ModelAttribute Survey survey,
                                ModelMap model,
                                HttpSession httpSession){
        surveyService.persist(survey);
        surveyList = surveyService.findAll(new Survey());

        model.addAttribute("info", "Neue Umfrage hinzugefügt.");
        model.addAttribute("site", "surveys");
        model.addAttribute("id", survey.getId());
        model.addAttribute("name", survey.getName());

        model.addAttribute("surveyList", surveyList);
        return "index";
    }
}
