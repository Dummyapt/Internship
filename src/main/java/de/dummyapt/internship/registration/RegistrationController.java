package de.dummyapt.internship.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationController {
    @GetMapping("/register")
    public String register() {
        return "register";
    }
}