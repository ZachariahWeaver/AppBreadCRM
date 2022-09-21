package com.personalproject.AppBreadCRM.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @GetMapping(value = "/login")
    public ModelAndView login(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("login");
        return maw;
    }
}
