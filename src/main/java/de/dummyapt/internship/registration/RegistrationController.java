package de.dummyapt.internship.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * {@link Controller} for Registration page
 */
@Controller
public class RegistrationController {

    /**
     * GET request handler to confirm tokens
     * @return register.html from the resources/ directory
     * with model attributes added in a hidden div container
     */
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";
    }
}