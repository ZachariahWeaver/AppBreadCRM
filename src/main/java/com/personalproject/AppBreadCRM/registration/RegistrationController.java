package com.personalproject.AppBreadCRM.registration;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @GetMapping(value = "/registration")
    public ModelAndView registrationPage(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("registration");
        maw.addObject("req", new RegistrationRequest());
        return maw;
    }

    @PostMapping(value = "/registration")
    public ModelAndView register(@ModelAttribute("req") RegistrationRequest request){
        registrationService.register(request);
        return new ModelAndView("redirect:/");
    }
}
