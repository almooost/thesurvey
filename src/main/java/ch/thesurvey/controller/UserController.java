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
 * @version v0.1
 */
@Controller
public class UserController{

    @Autowired
    private UserServiceInterface userService;

    private List<ModelInterface> userList;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUser(@RequestParam(value = "action", required = false, defaultValue = "manage")String action,
                          ModelMap model,
                          HttpSession httpSession){

        switch (action){
            case "manage":
                userList = userService.findAll(new User());
                break;
            default:
                userList = userService.findAll(new User());
                break;
        }

        model.addAttribute("userList",userList);
        model.addAttribute("action", action);
        model.addAttribute("site","user");
        return "index";
    }

    /**
     * Is this even used?
     * @return
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
     */

}
