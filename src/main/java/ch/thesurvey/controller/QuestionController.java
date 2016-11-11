package ch.thesurvey.controller;

import ch.thesurvey.model.Question;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.QuestionInterface;
import ch.thesurvey.service.interfaces.QuestionServiceInterface;
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
 * Serves paths for questions
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class QuestionController {

    @Autowired
    QuestionServiceInterface questionService;

    List<ModelInterface> questionList;

    @RequestMapping("/surveys/questions")
    public String getSurvey(@RequestParam(value = "action", required = false, defaultValue = "manage")String action,
                            ModelMap model,
                            HttpSession httpSession){

        switch (action){
            case "manage":
                questionList = questionService.findAll(new Question());
                break;
            default:
                questionList = questionService.findAll(new Question());
        }

        model.addAttribute("action", action);
        model.addAttribute("questionList", questionList);
        model.addAttribute("site","question");
        return "index";
    }

    @RequestMapping(value = "/surveys/questions/view", method = RequestMethod.GET)
    public String editQuestion(@RequestParam(value = "id", required = false, defaultValue = "")String id,
                                 ModelMap model,
                                 HttpSession httpSession){

        ModelInterface question = null;

        if(id.matches("^[\\d+]$")) {
            question = questionService.findById(Integer.parseInt(id));
        }

        model.addAttribute("question", question);
        model.addAttribute("site","question_edit");
        return "index";
    }

    @RequestMapping(value = "/surveys/questions/new", method = RequestMethod.GET)
    public String newSurvey(@RequestParam(value = "action", required = false, defaultValue = "new")String action,
                            ModelMap model,
                            HttpSession httpSession){

        model.addAttribute("username", "sam");
        model.addAttribute("site", "question_new");
        return "index";
    }

    @RequestMapping(value = "/surveys/questions/add", method = RequestMethod.POST)
    public String addSurvey(@ModelAttribute Question question,
                            ModelMap model,
                            HttpSession httpSession){
        questionService.persist(question);
        questionList = questionService.findAll(new Question());

        model.addAttribute("info", "Frage hinzugefügt.");
        model.addAttribute("site", "questions");
        model.addAttribute("id", question.getId());
        model.addAttribute("name", question.getName());

        model.addAttribute("questionList", questionList);
        return "index";
    }
}
