package ch.thesurvey.controller;

import ch.thesurvey.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Handle sinup/out requests
 * @author Samuel Alfano
 * @date 5.11.2016
 * @version v0.1
 */
@Controller
public class AuthenticationController {

    @Autowired
    private UserServiceInterface userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false, defaultValue = "") String error, ModelMap model, HttpSession httpSession){
        if(!error.isEmpty())
           model.addAttribute("error", "Anmeldung fehlgeschlagen,!");
        else
            model.addAttribute("info", "Herzlich willkommen");
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username", required = false)String username,
                        @RequestParam(value = "password", required = false)String password,
                        ModelMap model,
                        HttpSession httpSession){

        /*
        if( (httpSession.getAttribute("user") != null) &&
                httpSession.getAttribute("user").getClass() == User.class) {

            model.addAttribute("site", "home");
            return "index";
        }
        else {
            try {

                User searchModel = new User(username, password);
                User userModel = userService.findByUser(searchModel);
                if (PasswordStorage.verifyPassword(searchModel.getPassword(), userModel.getPassword())) {
                    searchModel = null;
                    model.addAttribute("username", userModel.getUsername());
                    model.addAttribute("success", "Login successful");
                    httpSession.setAttribute("user", userModel);
                    model.addAttribute("site", "home");
                    return "index";
                }
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
            }
        }
        */
        model.addAttribute("error", "reached");
        return "signup";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model, HttpSession httpSession){
        httpSession.setAttribute("user", null);
        httpSession = null;
        model.addAttribute("site", "login");
        return "signup";
    }
}
