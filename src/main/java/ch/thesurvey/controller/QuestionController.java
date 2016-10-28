package ch.thesurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Serves paths for questions
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class QuestionController extends AbstractController {

    @RequestMapping("/surveys/questions")
    public String getSurvey(@RequestParam(value = "question", required = false, defaultValue = "none")String question, ModelMap model){
        model.addAttribute("site","question");
        model.addAttribute("action", "manage");
        return "index";
    }
}
