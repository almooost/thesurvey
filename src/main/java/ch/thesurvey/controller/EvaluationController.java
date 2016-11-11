package ch.thesurvey.controller;

import ch.thesurvey.model.Evaluation;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.service.interfaces.EvaluationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
}
