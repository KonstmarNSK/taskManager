package com.kostya.controllers;

import com.kostya.forms.RegisterForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/register")
public class RegistrationPageController {
    @Autowired
    private SessionFactory sessionFactory;

    @GetMapping
    public String showRegistrationPage(){
        return "register";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("user") RegisterForm userForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "register";
        }

        Session session = sessionFactory.openSession();
        session.save(userForm.intoUser());
        session.close();

        return "redirect:/home";
    }
}
