package com.practice.PMsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedPageController {

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
