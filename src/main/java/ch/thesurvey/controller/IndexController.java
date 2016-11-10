package ch.thesurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sam on 23.10.16.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String getSite(@RequestParam(value = "site", required = false, defaultValue = "home")String site, Model model){
        model.addAttribute("site",site);
        return "index";
    }
}
