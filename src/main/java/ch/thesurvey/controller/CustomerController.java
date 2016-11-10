package ch.thesurvey.controller;

import ch.thesurvey.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Serves paths for customers
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.1
 */
@Controller
public class CustomerController {

    @RequestMapping("/customers")
    public String getCustomer(@RequestParam(value = "survey", required = false, defaultValue = "none")String customer, ModelMap model){
        model.addAttribute("site","customer");
        model.addAttribute("action", "manage");
        return "index";
    }

    /*
    public ModelAndView getCustomer(@RequestParam(value = "customer", defaultValue = "none", required = false)Customer customer, ModelAndView model){
        return model.addObject("customer", customer);
    }
    */
}
