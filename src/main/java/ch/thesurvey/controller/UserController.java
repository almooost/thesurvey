package ch.thesurvey.controller;

import ch.thesurvey.model.User;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Serves paths for users
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.2
 */
@Controller
public class UserController{

    @Autowired
    private UserServiceInterface userService;

    private List<ModelInterface> userList;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUser(ModelMap model,
                          HttpSession httpSession){


        userList = userService.findAll(new User());

        model.addAttribute("userList",userList);
        model.addAttribute("site","user");
        return "index";
    }

}
