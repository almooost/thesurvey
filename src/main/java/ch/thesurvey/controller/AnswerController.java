package ch.thesurvey.controller;

import ch.thesurvey.model.Answer;
import ch.thesurvey.model.interfaces.AnswerInterface;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.service.interfaces.AnswerServiceInterface;
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
 * Serves paths for answers
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
@RequestMapping(value = "/app/answers/")
public class AnswerController {

    @Autowired
    AnswerServiceInterface answerService;

    List<ModelInterface> answerList;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAnswer(@RequestParam(value = "action", required = false, defaultValue = "manage")String action,
                            ModelMap model,
                            HttpSession httpSession){

        switch (action){
            case "manage":
                answerList = answerService.findAll(new Answer());
                break;
            default:
                answerList = answerService.findAll(new Answer());
        }
        model.addAttribute("answerList",answerList);
        model.addAttribute("action", action);
        model.addAttribute("site","answer");
        return "index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editAnswer(@RequestParam(value = "id", required = false, defaultValue = "")String id,
                               ModelMap model,
                               HttpSession httpSession){

        ModelInterface answer = null;

        if(id.matches("^[\\d+]$")) {
            answer = answerService.findById(Integer.parseInt(id));
        }

        model.addAttribute("answer", answer);
        model.addAttribute("site","answer_edit");
        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAnswer(@RequestParam(value = "action", required = false, defaultValue = "new")String action,
                            ModelMap model,
                            HttpSession httpSession){

        model.addAttribute("username", "sam");
        model.addAttribute("site", "survey_new");
        return "index";
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public String addAnswer(@ModelAttribute Answer survey,
                            ModelMap model,
                            HttpSession httpSession){
        answerService.persist(survey);
        answerList = answerService.findAll(new Answer());

        model.addAttribute("info", "Neue Umfrage hinzugefügt.");
        model.addAttribute("site", "answer");
        model.addAttribute("id", survey.getId());
        model.addAttribute("name", survey.getName());

        model.addAttribute("answerList", answerList);
        return "redirect:/answers/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteAnswer(@RequestParam(value = "action", required = true, defaultValue = "delte")String action,
                               @RequestParam(value = "id", required = true) String id,
                                ModelMap model,
                                HttpSession httpSession){

        if(action.contentEquals("delete")) {

            ModelInterface answer = answerService.findById(Integer.parseInt(id));

            if(answer instanceof AnswerInterface && answer.getName() != null){
                answerService.remove(answer);
                model.addAttribute("info", "Antwort gelöscht");
            }
            else {
                model.addAttribute("warning", "Antwort konnte nicht gelöscht werden!");
            }

        }
        answerList = answerService.findAll(new Answer());

        model.addAttribute("site", "answers");
        model.addAttribute("answerList",answerList);

        return "redirect:/app/answers";

    }
}
