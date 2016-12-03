package ch.thesurvey.controller;

import ch.thesurvey.model.Customer;
import ch.thesurvey.model.interfaces.ModelInterface;
import ch.thesurvey.service.interfaces.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Serves paths for customers
 * @author Samuel Alfano
 * @date 28.10.2016
 * @version v0.2
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerServiceInterface customerService;

    List<ModelInterface> customerList;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String getCustomer(ModelMap model,
                              HttpSession httpSession){

        customerList = customerService.findAll(new Customer());

        model.addAttribute("customerList", customerList);
        model.addAttribute("site", "customer");
        return "index";
    }
}
