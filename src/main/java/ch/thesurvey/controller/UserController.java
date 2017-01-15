package ch.thesurvey.controller;

import ch.thesurvey.model.User;
import ch.thesurvey.model.interfaces.UserInterface;
import ch.thesurvey.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Serves paths for users
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.3
 */
@Controller
@RequestMapping(value = "/app/users/")
public class UserController{

    @Autowired
    private UserServiceInterface userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUser(ModelMap model){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User currentUser = new User();
        currentUser.setUsername(currentPrincipalName);

        UserInterface user = userService.findByUser(currentUser);

        model.addAttribute("user",user);
        model.addAttribute("site","user");
        return "index";
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public String persistUser(@ModelAttribute User user,
                            ModelMap model,
                            HttpSession httpSession){

        user.setStatus(1);
        userService.persist(user);

        model.addAttribute("info", "Benutzer gespeichert.");
        model.addAttribute("site", "user");
        model.addAttribute("id", user.getId());
        model.addAttribute("name", user.getName());

        return "redirect:/app/";
    }

}
