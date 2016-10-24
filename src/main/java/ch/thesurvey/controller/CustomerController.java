package ch.thesurvey.controller;

import ch.thesurvey.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sam on 23.10.16.
 */
@Controller
public class CustomerController extends AbstractController{

    public ModelAndView getCustomer(@RequestParam(value = "customer", defaultValue = "none", required = false)Customer customer, ModelAndView model){
        return model.addObject("customer", customer);
    }
}
