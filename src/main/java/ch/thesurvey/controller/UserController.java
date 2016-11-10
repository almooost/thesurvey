package ch.thesurvey.controller;

import ch.thesurvey.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Serves paths for users
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class UserController{

    @Autowired
    private IUserService userService;


    @RequestMapping("/users")
    public String getUser(@RequestParam(value = "user", required = false, defaultValue = "none")String user, ModelMap model, HttpSession httpSession){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
