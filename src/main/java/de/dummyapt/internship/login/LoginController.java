package de.dummyapt.internship.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * {@link Controller} for Login page
 */
@Controller
public class LoginController {
    /**
     * Maps incoming GET requests for http://localhost:8080/login
     * @return login.html from the resources/ directory
     */
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}