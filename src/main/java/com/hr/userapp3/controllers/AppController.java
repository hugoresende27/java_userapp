package com.hr.userapp3.controllers;


import com.hr.userapp3.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping ("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());

        return "signup_form";

    }
}
