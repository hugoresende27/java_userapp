package com.hr.userapp3.controllers;


import com.hr.userapp3.helpers.CustomUserDetails;
import com.hr.userapp3.models.User;
import com.hr.userapp3.repositories.UserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserRepository repo;
    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping ("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());

        return "signup_form";

    }

    @PostMapping("/process_register")
    public String processRegistration(User user){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);

        return "register_success";
    }

    @GetMapping("/list_users")
    public String viewusersList(Model model, Authentication authentication){

        List<User> listUsers = repo.findAll();

        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String fullName = auth.getName();
        System.out.println(fullName);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("fullName", fullName);

        return "users";
    }
}
