package ch.thesurvey.controller;

import ch.thesurvey.model.Evaluation;
import ch.thesurvey.model.interfaces.EvaluationInterface;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.service.interfaces.EvaluationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Serves paths for evaluations
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class EvaluationController {

    @Autowired
    EvaluationServiceInterface evaluationService;

    List<ModelInterface> evaluationList;

    @RequestMapping(value = "/evaluations", method = RequestMethod.GET)
    public String getSurvey(@RequestParam(value = "action", required = false, defaultValue = "manage")String action,
                            ModelMap model,
                            HttpSession httpSession){

        switch (action){
            case "manage":
                evaluationList = evaluationService.findAll(new Evaluation());
                break;
            default:
                evaluationList = evaluationService.findAll(new Evaluation());
                break;
        }

        model.addAttribute("evaluationList", evaluationList);
        model.addAttribute("action", action);
        model.addAttribute("site","evaluation");
        return "index";
    }

    @RequestMapping(value = "/surveys/evaluations/view", method = RequestMethod.GET)
    public String editEvaluation(@RequestParam(value = "id", required = false, defaultValue = "")String id,
                               ModelMap model,
                               HttpSession httpSession){

        ModelInterface evaluation = null;

        if(id.matches("^[\\d+]$")) {
            evaluation = evaluationService.findById(Integer.parseInt(id));
        }

        model.addAttribute("evaluation", evaluation);
        model.addAttribute("site","evaluation_edit");
        return "index";
    }

    @RequestMapping(value = "/surveys/evaluations/new", method = RequestMethod.GET)
    public String newSurvey(@RequestParam(value = "action", required = false, defaultValue = "new")String action,
                            ModelMap model,
                            HttpSession httpSession){

        model.addAttribute("username", "sam");
        model.addAttribute("site", "evaluation_new");
        return "index";
    }

    @RequestMapping(value = "/surveys/evaluations/add", method = RequestMethod.POST)
    public String addSurvey(@ModelAttribute Evaluation evaluation,
                            ModelMap model,
                            HttpSession httpSession){
        evaluationService.persist(evaluation);
        evaluationList = evaluationService.findAll(new Evaluation());

        model.addAttribute("info", "Frage hinzugefügt.");
        model.addAttribute("site", "evaluations");
        model.addAttribute("id", evaluation.getId());
        model.addAttribute("name", evaluation.getName());

        model.addAttribute("evaluationList", evaluationList);
        return "index";
    }

    @RequestMapping(value = "/surveys/evaluations/delete", method = RequestMethod.POST)
    public String deleteSurvey(@RequestParam(value = "action", required = true, defaultValue = "delte")String action,
                               @RequestParam(value = "id", required = true) String id,
                               ModelMap model,
                               HttpSession httpSession){

        if(action.contentEquals("delete")) {

            ModelInterface evaluation = evaluationService.findById(Integer.parseInt(id));

            if (evaluation instanceof EvaluationInterface && evaluation.getName() != null) {
                evaluationService.remove(evaluation);
                model.addAttribute("info", "Frage gelöscht");
            } else
                model.addAttribute("warning", "Frage konnte nicht gelöscht werden!");
        }

        evaluationList = evaluationService.findAll(new Evaluation());

        model.addAttribute("site", "evaluations");
        model.addAttribute("evaluationList",evaluationList);
        return "redirect:/surveys/evaluations";
    }
}
