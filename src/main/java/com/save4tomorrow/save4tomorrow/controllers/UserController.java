package com.save4tomorrow.save4tomorrow.controllers;

import org.springframework.stereotype.Controller;
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
}
