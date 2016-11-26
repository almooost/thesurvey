package ch.thesurvey.controller;

import ch.thesurvey.model.*;
import ch.thesurvey.model.interfaces.*;
import ch.thesurvey.service.interfaces.*;
import ch.thesurvey.utility.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    private List<ModelInterface> contactList;
    private List<ModelInterface> questionList;

    @Autowired
    private SurveyServiceInterface surveyService;

    @Autowired
    private ContactServiceInterface contactService;

    @Autowired
    private QuestionServiceInterface questionService;

    @Autowired
    private SurveyContactServiceInterface surveyContactService;

    @Autowired
    private SurveyQuestionServiceInterface surveyQuestionService;

    public SurveyController(){
        surveyList = new ArrayList<ModelInterface>();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getSurvey(@RequestParam(value = "action", required = false, defaultValue = "manage")String action,
                            ModelMap model,
                            HttpSession httpSession){

        surveyList = surveyService.findAll(new Survey());

        model.addAttribute("surveyList", surveyList);
        model.addAttribute("site","survey");
        return "index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editSurvey(@RequestParam(value = "id", required = true)String id,
                            ModelMap model,
                            HttpSession httpSession){

        if(id.matches("^[\\d+]$")) {
            SurveyInterface survey = (SurveyInterface)surveyService.findById(Integer.parseInt(id));
            List<SurveyContactInterface> surveyContactList = survey.getSurveyContacts();
            List<SurveyQuestionInterface> surveyQuestionList = survey.getSurveyQuestions();
            model.addAttribute("surveyContactList", surveyContactList);
            model.addAttribute("surveyQuestionList", surveyQuestionList);
            model.addAttribute("survey", survey);
        }
        contactList = contactService.findAll(new Contact());
        questionList = questionService.findAll(new Question());

        model.addAttribute("contactList", contactList);
        model.addAttribute("questionList", questionList);
        model.addAttribute("id", id);
        model.addAttribute("site","survey_edit");
        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newSurvey(@RequestParam(value = "action", required = false, defaultValue = "new")String action,
                            ModelMap model,
                            HttpSession httpSession){

        Survey survey = new Survey();
        survey.setAuthor("sam");
        model.addAttribute("username", "sam");
        model.addAttribute("site", "survey_new");
        model.addAttribute("survey", survey);
        return "index";
    }

    @RequestMapping(value = "/contacts/add", method = RequestMethod.GET)
    public String addContact(@RequestParam(value = "id", required = true)String id,
                             @RequestParam(value = "contact_id", required = true) String contactId,
                            ModelMap model,
                            HttpSession httpSession){

        System.out.println("Reached addContact, id: "+id);
        System.out.println("Reached addContact, contactId: "+contactId);

        if(id.matches("^[\\d+]$") && contactId.matches("^[\\d+]$")) {
            SurveyContact surveyContact = new SurveyContact();

            SurveyInterface survey = (SurveyInterface)surveyService.findById(Integer.parseInt(id));
            surveyContact.setSurvey(survey);
            surveyContact.setContact((ContactInterface)contactService.findById(Integer.parseInt(contactId)));

            surveyContact.setToken(UUID.randomUUID().toString());
            surveyContact.setTokenUntil(survey.getEndDate());

            surveyContactService.persist(surveyContact);
            model.addAttribute("info", "Kontakt erfolgreich zur Umfrage hinzugefügt");
            model.addAttribute("survey", survey);
        }

        model.addAttribute("username", "sam");
        model.addAttribute("site", "survey_new");
        model.addAttribute("id", id);
        return "redirect:/app/surveys/edit";
    }

    @RequestMapping(value = "/contacts/delete", method = RequestMethod.GET)
    public String deleteContact(@RequestParam(value = "action", required = false, defaultValue = "delete_contact")String action,
                             @RequestParam(value = "id", required = true)String id,
                             @RequestParam(value = "contact_id", required = true) String contactId,
                             ModelMap model,
                             HttpSession httpSession){

        System.out.println("Reached deleteContact, id: "+id);
        System.out.println("Reached deleteContact, contactId: "+contactId);

        if(id.matches("^[\\d+]$") && contactId.matches("^[\\d+]$")) {
            SurveyContactInterface surveyContact = (SurveyContactInterface)surveyContactService.findById(Integer.parseInt(contactId));
            surveyContactService.remove(surveyContact);

            model.addAttribute("info", "Kontakt von Umfrage gelöscht");
            model.addAttribute("id", id);
            return "redirect:/app/surveys/edit";
        }
        return "redirect:/app/surveys/";
    }

    @RequestMapping(value = "/questions/add", method = RequestMethod.GET)
    public String addQuestion(@RequestParam(value = "id", required = true)String id,
                             @RequestParam(value = "question_id", required = true) String questionId,
                             ModelMap model,
                             HttpSession httpSession){

        System.out.println("Reached addQuestion, id: "+id);
        System.out.println("Reached addQuestion, questionId: "+questionId);

        if(id.matches("^[\\d+]$") && questionId.matches("^[\\d+]$")) {
            SurveyQuestionInterface surveyQuestion = new SurveyQuestion();

            SurveyInterface survey = (SurveyInterface)surveyService.findById(Integer.parseInt(id));
            surveyQuestion.setSurvey(survey);
            QuestionInterface question = (QuestionInterface)questionService.findById(Integer.parseInt(questionId));
            System.out.println("Got question from db, name:"+question.getName());
            surveyQuestion.setQuestion(question);

            surveyQuestionService.persist(surveyQuestion);
            model.addAttribute("info", "Frage erfolgreich zur Umfrage hinzugefügt");
            model.addAttribute("survey", survey);
            model.addAttribute("id", id);
            return "redirect:/app/surveys/edit";

        }

        model.addAttribute("username", "sam");
        return "redirect:/app/surveys/";
    }

    @RequestMapping(value = "/questions/delete", method = RequestMethod.GET)
    public String deleteQuestion(@RequestParam(value = "id", required = true)String id,
                                @RequestParam(value = "question_id", required = true) String questionId,
                                ModelMap model,
                                HttpSession httpSession){

        System.out.println("Reached deleteQuestion, id: "+id);
        System.out.println("Reached deleteQuestion, questionId: "+questionId);

        if(id.matches("^[\\d+]$") && questionId.matches("^[\\d+]$")) {
            SurveyQuestionInterface surveyQuestion = (SurveyQuestionInterface)surveyQuestionService.findById(Integer.parseInt(questionId));
            surveyQuestionService.remove(surveyQuestion);

            model.addAttribute("info", "Frage von Umfrage gelöscht");
            model.addAttribute("id", id);
            return "redirect:/app/surveys/edit";
        }
        return "redirect:/app/surveys/";
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)

    public String addSurvey(@ModelAttribute Survey survey, BindingResult bindingResult, ModelMap model){
        System.out.println("/persist successfully reachaed");
        System.out.println(survey.getStartDate());
        System.out.println(survey.getEndDate());
        System.out.println("PERSIST CALLED");
        survey.setStatus(1);
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

    @RequestMapping(value = "/execute")
    public String sendMail(@RequestParam(value = "id", required = false) String id,
                           ModelMap model,
                           HttpSession httpSession)
    {

        SurveyInterface survey = null;

        if(id.matches("^[\\d+]$")) {
            survey = (SurveyInterface)surveyService.findById(Integer.parseInt(id));
        }

        String msg = "";

        try {
            Mail mail = new Mail();
            mail.setSurvey(survey);
            mail.setContactList(survey.getSurveyContacts());

            if (mail.send()) {
                msg = "Umfrage wurde erfolgreich ausgeführt";
                surveyService.persist(survey);
            } else {
                msg = "Umfrage konnte nicht ausgeührt werden, es ist ein interner Fehler aufgetreten";
            }

        }
        catch (MessagingException e){
            System.out.println(e.getMessage());
            msg = "Es ist ein interner Fehler aufgetreten!";
        }

        surveyList = surveyService.findAll(new Survey());
        model.addAttribute("info", msg);
        model.addAttribute("site", "survey");
        model.addAttribute("surveyList",surveyList);
        return "redirect:/app/surveys/";

    }
}
