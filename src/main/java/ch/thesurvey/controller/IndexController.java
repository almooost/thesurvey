package ch.thesurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Main controller for basic paths
 * @author Samuel Alfano
 * @date 23.10.2016
 * @version v0.3
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String getSite(){
        return "redirect:/app/";
    }

    @RequestMapping("/app/")
    public String getSite(@RequestParam(value = "site", required = false, defaultValue = "home")String site, Model model){
        model.addAttribute("site",site);
        return "index";
    }
}
