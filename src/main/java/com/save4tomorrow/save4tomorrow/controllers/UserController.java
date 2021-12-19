package com.save4tomorrow.save4tomorrow.controllers;

import com.save4tomorrow.save4tomorrow.models.User;
import com.save4tomorrow.save4tomorrow.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

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

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }


    @GetMapping("/navbar")
    public String viewNavbar() {
        return "navbar";
    }

    @GetMapping("/profile")
    public String viewProfile() {
        return "profile";
    }
}



