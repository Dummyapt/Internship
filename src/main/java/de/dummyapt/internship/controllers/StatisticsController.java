package de.dummyapt.internship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
    @GetMapping("/stats")
    public String showStats() {
        return "stats";
    }
}
