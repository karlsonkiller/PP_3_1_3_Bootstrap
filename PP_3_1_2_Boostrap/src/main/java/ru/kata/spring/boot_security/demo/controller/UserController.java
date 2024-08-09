package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@Controller
public class UserController {
    private final UserService userServ;

    @Autowired
    public UserController(UserService userServ) {
        this.userServ = userServ;
    }


    @GetMapping("/user")
    public String showUserPage(Principal principal, Model model) {
        model.addAttribute("user", userServ.findUserByUsername(principal.getName()));
        return "user";
    }
}


