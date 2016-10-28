package ch.thesurvey.controller;

import ch.thesurvey.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Serves paths for users
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class UserController extends AbstractController{

    @RequestMapping("/users")
    public String getUser(@RequestParam(value = "user", required = false, defaultValue = "none")String user, ModelMap model){
        model.addAttribute("site","user");
        model.addAttribute("action", "manage");
        return "index";
    }

    /*
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUser(@RequestParam(value = "site", defaultValue = "home", required = false)User user, ModelAndView model){
        return model.addObject("user", user);
    }
    */
}
