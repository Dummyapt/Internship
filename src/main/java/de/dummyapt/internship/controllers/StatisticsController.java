package de.dummyapt.internship.controllers;

import de.dummyapt.internship.services.api.StatisticsServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
    private final StatisticsServiceAPI statisticsService;

    @Autowired
    public StatisticsController(StatisticsServiceAPI statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/stats")
    public String showStats(Model model) {
        model.addAttribute("SHP", statisticsService.getStatisticsCountBy(1));
        model.addAttribute("Spot", statisticsService.getStatisticsCountBy(2));
        model.addAttribute("Flex", statisticsService.getStatisticsCountBy(3));
        model.addAttribute("Base", statisticsService.getStatisticsCountBy(4));
        model.addAttribute("Flex2", statisticsService.getStatisticsCountBy(5));
        model.addAttribute("Peak", statisticsService.getStatisticsCountBy(6));
        return "stats";
    }
}