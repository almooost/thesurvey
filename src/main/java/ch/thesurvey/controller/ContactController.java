package ch.thesurvey.controller;

import ch.thesurvey.model.Contact;
import ch.thesurvey.model.interfaces.ContactInterface;
import ch.thesurvey.model.interfaces.ModelInterface;
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
 * @version v0.2
 */
@Controller
@RequestMapping(value = "/app/contacts/")
public class ContactController {

    @Autowired
    ContactServiceInterface contactService;

    List<ModelInterface> contactList;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getContacts(ModelMap model,
                              HttpSession httpSession){


        contactList = contactService.findAll(new Contact());

        model.addAttribute("contactList", contactList);
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
    public String newContact(ModelMap model,
                            HttpSession httpSession){

        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        model.addAttribute("username", "sam");
        model.addAttribute("site", "contact_new");
        return "index";
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public String addContact(@ModelAttribute Contact contact,
                            ModelMap model,
                            HttpSession httpSession){

        contact.setStatus(1);
        contactService.persist(contact);
        contactList = contactService.findAll(new Contact());

        httpSession.setAttribute("info", "Kontakt hinzugefügt.");

        model.addAttribute("site", "contacts");
        model.addAttribute("id", contact.getId());
        model.addAttribute("name", contact.getName());

        model.addAttribute("contactList", contactList);
        return "redirect:/app/contacts/";
    }

    @RequestMapping(value = "/delete")
    public String deleteContact(@RequestParam(value = "id", required = true) String id,
                               ModelMap model,
                               HttpSession httpSession){

        ModelInterface contact = contactService.findById(Integer.parseInt(id));

        if (contact instanceof ContactInterface && contact.getName() != null) {
            contactService.remove(contact);
            httpSession.setAttribute("info", "Kontakt gelöscht");
        } else
            httpSession.setAttribute("info", "Kontakt konnte nicht gelöscht werden!");

        contactList = contactService.findAll(new Contact());

        model.addAttribute("site", "contacts");
        model.addAttribute("contactList",contactList);
        return "index";
    }
}
