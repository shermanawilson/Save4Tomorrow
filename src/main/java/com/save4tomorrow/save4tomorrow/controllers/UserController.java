package com.save4tomorrow.save4tomorrow.controllers;

import com.save4tomorrow.save4tomorrow.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/home")
    public String homeView() {
        return "home";
    }

    @GetMapping("/resources")
    public String resourcesView() {
        return "resources";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }
}
