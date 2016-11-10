package ch.thesurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Serves paths for contacts
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class ContactController {

    @RequestMapping("/contacts")
    public String getContacts(@RequestParam(value = "contact", required = false, defaultValue = "none")String contact, ModelMap model){
        model.addAttribute("site","contact");
        model.addAttribute("action", "manage");
        return "index";
    }
}
