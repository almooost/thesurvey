package ch.thesurvey.controller;

import ch.thesurvey.model.Contact;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.service.ContactService;
import ch.thesurvey.service.interfaces.ContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Serves paths for contacts
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class ContactController {

    @Autowired
    ContactServiceInterface contactService;

    List<ModelInterface> contactList;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String getContacts(@RequestParam(value = "action", required = false, defaultValue = "manage")String action,
                              ModelMap model,
                              HttpSession httpSession){

        switch (action){
            case "manage":
                contactList = contactService.findAll(new Contact());
                break;
            default:
                contactList = contactService.findAll(new Contact());
                break;
        }

        model.addAttribute("contactList", contactList);
        model.addAttribute("action", action);
        model.addAttribute("site","contact");
        return "index";
    }
}
