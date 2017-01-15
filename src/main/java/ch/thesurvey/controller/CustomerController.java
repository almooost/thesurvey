package ch.thesurvey.controller;

import ch.thesurvey.model.Customer;
import ch.thesurvey.model.interfaces.CustomerInterface;
import ch.thesurvey.service.interfaces.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Serves paths for customers
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.3
 */
@Controller
@RequestMapping(value = "/app/customers/")
public class CustomerController {

    @Autowired
    CustomerServiceInterface customerService;

    @RequestMapping(value = "/")
    public String getCustomer(ModelMap model, HttpSession httpSession){

        CustomerInterface customer = (CustomerInterface) customerService.findById((Integer) httpSession.getAttribute("user_customer_id"));

        model.addAttribute("customer", customer);
        model.addAttribute("site", "customer");

        return "index";
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public String persistCustomer(@ModelAttribute Customer customer,
                              ModelMap model,
                              HttpSession httpSession){

        CustomerInterface customCustomer = (CustomerInterface) customerService.findById((Integer) httpSession.getAttribute("user_customer_id"));

        customCustomer.setName(customer.getName());
        customerService.persist(customCustomer);

        httpSession.setAttribute("info", "Kundeninformationen gespeichert.");

        return "redirect:/app/";
    }
}
