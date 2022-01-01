package com.save4tomorrow.save4tomorrow.controllers;

import com.save4tomorrow.save4tomorrow.models.User;
import com.save4tomorrow.save4tomorrow.models.Why;
import com.save4tomorrow.save4tomorrow.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChallengesController {
    private UserRepository userRepo;

    @GetMapping("/challenges/main")
    public String mainChallengesView() {
        return "challenges";
    }

    @GetMapping("/challenges/52Week")
    public String fWeekChallengeView() {
        return "52week";
    }

    @PostMapping("/challenges/52Week")
    public String fWeekChallenge() {
        return "52week";
    }

    @GetMapping("/challenges/weather")
    public String weatherChallengeView(Model model) {
        User currentUserSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("why", userRepo.getById(currentUserSession.getId()));
        //model.addAttribute("why", new Why());
        //reference description by ow
        return "weather";
    }

    @PostMapping("/challenges/weather")
    public String weatherChallenge() {
        return "weather";
    }

    @GetMapping("/challenges/noSpend")
    public String noSpendChallengeView() {
        return "nospend";
    }

    @PostMapping("/challenges/noSpend")
    public String noSpendChallenge() {
        return "nospend";
    }

    @GetMapping("/challenges/bingo")
    public String bingoChallengeView() {
        return "bingo";
    }

    @PostMapping("/challenges/bingo")
    public String bingoChallenge() {
        return "bingo";
    }
}
