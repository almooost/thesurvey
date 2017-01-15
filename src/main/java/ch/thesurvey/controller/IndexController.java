package ch.thesurvey.controller;

import ch.thesurvey.model.Survey;
import ch.thesurvey.model.User;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.model.interfaces.UserInterface;
import ch.thesurvey.service.interfaces.SurveyServiceInterface;
import ch.thesurvey.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Main controller for basic paths
 * @author Samuel Alfano
 * @version v0.4
 */
@Controller
public class IndexController {

    private List<ModelInterface> surveyList;

    @Autowired
    private SurveyServiceInterface surveyService;

    @Autowired
    private UserServiceInterface userService;

    @RequestMapping("/")
    public String getSite(HttpSession httpSession){

        return "redirect:/app/";
    }

    @RequestMapping("/app/")
    public String getSite(ModelMap model, HttpSession httpSession){

        setUserSession(httpSession);

        surveyList = surveyService.findAll(new Survey());

        model.addAttribute("surveyList", surveyList);
        model.addAttribute("site","home");
        return "index";
    }

    public void setUserSession(HttpSession httpSession){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User currentUser = new User();
        currentUser.setUsername(currentPrincipalName);

        UserInterface user = userService.findByUser(currentUser);

        httpSession.setAttribute("username", user.getUsername());
        httpSession.setAttribute("user_givenname", user.getGivenname());
        httpSession.setAttribute("user_name", user.getName());
        httpSession.setAttribute("user_customer_id", user.getCustomer().getId());
        httpSession.setAttribute("user_customer_name", user.getCustomer().getName());
    }
}
