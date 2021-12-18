package com.save4tomorrow.save4tomorrow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChallengesController {
    @GetMapping("/challenges/main")
    public String mainChallengesView() {
        return "challenges";
    }
}
