package ch.thesurvey.controller;

import ch.thesurvey.model.Answer;
import ch.thesurvey.model.Question;
import ch.thesurvey.model.interfaces.*;
import ch.thesurvey.service.interfaces.AnswerServiceInterface;
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
 * @version v0.2
 */
@Controller
@RequestMapping(value = "/app/questions/")
public class QuestionController {

    @Autowired
    QuestionServiceInterface questionService;

    @Autowired
    AnswerServiceInterface answerService;

    List<ModelInterface> questionList;

    @RequestMapping("/")
    public String getQuestion(ModelMap model,
                            HttpSession httpSession){

        questionList = questionService.findAll(new Question());

        model.addAttribute("questionList", questionList);
        model.addAttribute("site","question");
        return "index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editQuestion(@RequestParam(value = "id", required = true)String id,
                                 ModelMap model,
                                 HttpSession httpSession){

        ModelInterface question = null;

        if(id.matches("^[\\d+]$")) {
            question = questionService.findById(Integer.parseInt(id));

            List<ModelInterface> answerList = answerService.findAll(new Answer());

            model.addAttribute("answerList", answerList);
            model.addAttribute("question", question);
            model.addAttribute("site","question_edit");
            return "index";
        }

        return "redirect:/app/questions/";


    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newQuestion(@RequestParam(value = "action", required = false, defaultValue = "new")String action,
                            ModelMap model,
                            HttpSession httpSession){
        Question question = new Question();
        question.setType("text");
        model.addAttribute("question", question);
        model.addAttribute("username", "sam");
        model.addAttribute("site", "question_new");
        return "index";
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute Question question,
                            ModelMap model,
                            HttpSession httpSession){

        question.setStatus(1);
        questionService.persist(question);
        questionList = questionService.findAll(new Question());


        httpSession.setAttribute("info", "Frage hinzugefügt.");

        model.addAttribute("site", "questions");
        model.addAttribute("id", question.getId());
        model.addAttribute("name", question.getName());

        model.addAttribute("questionList", questionList);
        return "redirect:/app/questions/";
    }

    @RequestMapping(value = "/delete")
    public String deleteQuestion(@RequestParam(value = "id", required = true) String id,
                               ModelMap model,
                               HttpSession httpSession){



        ModelInterface question = questionService.findById(Integer.parseInt(id));

        if (question instanceof QuestionInterface && question.getName() != null) {
            questionService.remove(question);
            httpSession.setAttribute("info", "Frage gelöscht");
        } else
            httpSession.setAttribute("warning", "Frage konnte nicht gelöscht werden!");


        questionList = questionService.findAll(new Question());

        model.addAttribute("site", "questions");
        model.addAttribute("questionList",questionList);
        return "redirect:/app/questions/";
    }

    @RequestMapping(value = "/answers/add")
    public String addAnswer(@RequestParam(value = "id", required = true) String id,
                            @RequestParam(value = "answer_id", required = true) String answerId,
                            ModelMap model,
                            HttpSession httpSession){

            System.out.println("Reached addQuestion, id: "+id);
            System.out.println("Reached addQuestion, answerId: "+answerId);

            QuestionInterface question = (QuestionInterface)questionService.findById(Integer.parseInt(id));
            AnswerInterface answer = (AnswerInterface)answerService.findById(Integer.parseInt(answerId));

            if(answer != null && answer.getId() == Integer.parseInt(answerId)){
                System.out.println("Antwort stimmt überein und wird gespeichert.");
                question.setAnswer(answer);
                questionService.persist(question);
                httpSession.setAttribute("info", "Antwort zur Frage hinzugefügt");
            }
            else {
                httpSession.setAttribute("info", "Antwort konnte nicht zur Frage hinzugefügt werden!");
            }

            model.addAttribute("question", question);
            model.addAttribute("id", id);
            return "redirect:/app/questions/edit";

    }
}
