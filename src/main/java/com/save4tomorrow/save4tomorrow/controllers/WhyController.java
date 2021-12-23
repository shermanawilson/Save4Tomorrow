package com.save4tomorrow.save4tomorrow.controllers;

import com.save4tomorrow.save4tomorrow.models.User;
import com.save4tomorrow.save4tomorrow.models.Why;
import com.save4tomorrow.save4tomorrow.repositories.UserRepository;
import com.save4tomorrow.save4tomorrow.repositories.WhyRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WhyController {
    private final UserRepository userRepo;
    private final WhyRepository whyRepo;

    public WhyController(UserRepository userRepo, WhyRepository whyRepo) {
        this.userRepo = userRepo;
        this.whyRepo = whyRepo;
    }


    @GetMapping("/why/profile")
    public String whyInputGet(Model model) {
        User currentUserSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(currentUserSession);
        model.addAttribute("why", new Why());
        model.addAttribute("why", userRepo.getById(currentUserSession.getId())); //gets user by session
        return "profile";
    }
    @PostMapping("/why/profile")
    public String whyInput(@ModelAttribute Why why) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        whyRepo.save(why);

        why.setUser(userRepo.getById(currentUser.getId()));
        why.setDescription(why.getDescription());
        whyRepo.save(why);

        return "redirect:/profile";
    }
}

