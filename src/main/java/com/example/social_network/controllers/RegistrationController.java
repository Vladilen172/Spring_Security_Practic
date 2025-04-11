package com.example.social_network.controllers;

import com.example.social_network.model.User;
import com.example.social_network.dto.RegistrationRequest;
import com.example.social_network.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String register() {
        return "register";
    }

    @PostMapping
    public String registerUser(RegistrationRequest registrationRequest) {
        User user = registrationService.registerUser(registrationRequest);

        return "redirect:/login";
    }
}
