package ch.thesurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Serves paths for answers
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class AnswerController {

    @RequestMapping("/surveys/answers")
    public String getAnswer(@RequestParam(value = "answer", required = false, defaultValue = "none")String answer, ModelMap model){
        model.addAttribute("site","answer");
        model.addAttribute("action", "manage");
        return "index";
    }
}
