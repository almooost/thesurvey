package ch.thesurvey.controller;

import ch.thesurvey.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sam on 23.10.16.
 */
@Controller
public class UserController extends AbstractController{

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUser(@RequestParam(value = "user", defaultValue = "", required = false)User user, ModelAndView model){
        return model.addObject("user", user);
    }
}
