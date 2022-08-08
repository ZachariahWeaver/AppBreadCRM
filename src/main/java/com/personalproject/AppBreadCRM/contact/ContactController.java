package com.personalproject.AppBreadCRM.contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping(value = "/contact")
    public String contactPage(Model model){
        return "contact";
    }
}
