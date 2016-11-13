package ch.thesurvey.controller;

import ch.thesurvey.model.Contact;
import ch.thesurvey.model.interfaces.ContactInterface;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.service.ContactService;
import ch.thesurvey.service.interfaces.ContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping(value = "/app/contacts/")
public class ContactController {

    @Autowired
    ContactServiceInterface contactService;

    List<ModelInterface> contactList;

    @RequestMapping(value = "/", method = RequestMethod.GET)
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

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editContact(@RequestParam(value = "id", required = false, defaultValue = "")String id,
                                 ModelMap model,
                                 HttpSession httpSession){

        ModelInterface contact = null;

        if(id.matches("^[\\d+]$")) {
            contact = contactService.findById(Integer.parseInt(id));
        }

        model.addAttribute("contact", contact);
        model.addAttribute("site","contact_edit");
        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newSurvey(@RequestParam(value = "action", required = false, defaultValue = "new")String action,
                            ModelMap model,
                            HttpSession httpSession){

        model.addAttribute("username", "sam");
        model.addAttribute("site", "contact_new");
        return "index";
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public String addSurvey(@ModelAttribute Contact contact,
                            ModelMap model,
                            HttpSession httpSession){
        contactService.persist(contact);
        contactList = contactService.findAll(new Contact());

        model.addAttribute("info", "Frage hinzugefügt.");
        model.addAttribute("site", "contacts");
        model.addAttribute("id", contact.getId());
        model.addAttribute("name", contact.getName());

        model.addAttribute("contactList", contactList);
        return "redirect:/app/contacts/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteSurvey(@RequestParam(value = "action", required = true, defaultValue = "delte")String action,
                               @RequestParam(value = "id", required = true) String id,
                               ModelMap model,
                               HttpSession httpSession){

        if(action.contentEquals("delete")) {

            ModelInterface contact = contactService.findById(Integer.parseInt(id));

            if (contact instanceof ContactInterface && contact.getName() != null) {
                contactService.remove(contact);
                model.addAttribute("info", "Frage gelöscht");
            } else
                model.addAttribute("warning", "Frage konnte nicht gelöscht werden!");
        }

        contactList = contactService.findAll(new Contact());

        model.addAttribute("site", "contacts");
        model.addAttribute("contactList",contactList);
        return "index";
    }
}
