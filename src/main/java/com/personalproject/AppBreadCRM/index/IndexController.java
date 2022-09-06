package com.personalproject.AppBreadCRM.index;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = "")
    public String homePage(Model model){
        return "index";
    }

    @GetMapping(value = "/contact")
    public String contactPage(Model model){
        return "contact";
    }

}
