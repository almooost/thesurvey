package ch.thesurvey.controller;

import ch.thesurvey.model.Survey;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.SurveyInterface;
import ch.thesurvey.persistence.dao.interfaces.SurveyDaoInterface;
import ch.thesurvey.service.SurveyService;
import ch.thesurvey.service.interfaces.SurveyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping(value = "/app/surveys/")
public class SurveyController {

    private List<ModelInterface> surveyList;
    @Autowired
    private SurveyServiceInterface surveyService;

    public SurveyController(){
        surveyList = new ArrayList<ModelInterface>();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
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

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editSurvey(@RequestParam(value = "id", required = false, defaultValue = "")String id,
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

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newSurvey(@RequestParam(value = "action", required = false, defaultValue = "new")String action,
                            ModelMap model,
                            HttpSession httpSession){

        model.addAttribute("username", "sam");
        model.addAttribute("site", "survey_new");
        return "index";
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public String addSurvey(@ModelAttribute("survey") Survey survey,
                                BindingResult result,
                                ModelMap model,
                                HttpSession httpSession){

        System.out.println(survey.getStartDate());
        System.out.println(survey.getEndDate());
        System.out.println("PERSIST CALLED");
        surveyService.persist(survey);
        surveyList = surveyService.findAll(new Survey());

        model.addAttribute("info", "Neue Umfrage hinzugefügt.");
        model.addAttribute("site", "survey");
        model.addAttribute("id", survey.getId());
        model.addAttribute("name", survey.getName());

        model.addAttribute("surveyList", surveyList);
        return "redirect:/app/surveys/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteSurvey(@RequestParam(value = "action", required = true)String action,
                               @RequestParam(value = "id", required = true) String id,
                               ModelMap model,
                               HttpSession httpSession){

        if(action.contentEquals("delete")) {
            System.out.println("DELETE ACTION CALLED");

            ModelInterface survey = surveyService.findById(Integer.parseInt(id));

            if (survey.getName() != null) {
                System.out.println("REMOVE");

                surveyService.remove(survey);
                model.addAttribute("info", "Umfrage gelöscht");
            } else
                model.addAttribute("warning", "Umfrage konnte nicht gelöscht werden!");
        }

        surveyList = surveyService.findAll(new Survey());
        model = new ModelMap();
        model.addAttribute("site", "survey");
        model.addAttribute("surveyList",surveyList);
        return "redirect:/app/surveys";
    }
}
