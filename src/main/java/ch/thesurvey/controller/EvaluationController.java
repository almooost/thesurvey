package ch.thesurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Serves paths for evaluations
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class EvaluationController extends AbstractController{

    @RequestMapping("/evaluations")
    public String getSurvey(@RequestParam(value = "item", required = false, defaultValue = "none")String evaluation, ModelMap model){
        model.addAttribute("site","evaluation");
        model.addAttribute("action", "manage");
        return "index";
    }
}
