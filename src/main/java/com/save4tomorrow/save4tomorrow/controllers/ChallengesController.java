package com.save4tomorrow.save4tomorrow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChallengesController {
    @GetMapping("/challenges/main")
    public String mainChallengesView() {
        return "challenges";
    }

    @GetMapping("/challenges/52Week")
    public String fWeekChallengeView() {
        return "52week";
    }

    @GetMapping("/challenges/weather")
    public String weatherChallengeView() {
        return "weather";
    }

    @GetMapping("/challenges/noSpend")
    public String noSpendChallengeView() {
        return "nospend";
    }

    @GetMapping("/challenges/bingo")
    public String bingoChallengeView() {
        return "bingo";
    }
}
