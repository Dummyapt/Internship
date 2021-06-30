package de.dummyapt.internship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for Login service
 */
@Controller
public class LoginController {
    /**
     * Maps incoming GET requests for http://localhost:8080/login
     * @return login.html from the resources/ directory
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}