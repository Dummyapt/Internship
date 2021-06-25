package de.dummyapt.internship.controllers;

import de.dummyapt.internship.services.api.StatisticsServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for Statistics service
 */
@Controller
public class StatisticsController {
    /**
     * Class attribute providing methods from {@link de.dummyapt.internship.services.api.StatisticsServiceAPI}
     */
    private final StatisticsServiceAPI statisticsService;

    /**
     * Internally auto wiring class attributes with parameters
     */
    @Autowired
    public StatisticsController(StatisticsServiceAPI statisticsService) {
        this.statisticsService = statisticsService;
    }

    /**
     * Maps incoming GET requests for http://localhost:8080/stats
     * @param model Model gets attributes (Thymeleaf variables)
     *              that can be used in the returned html file
     * @return statistics.html from the resources/ directory
     * with model attributes added in a hidden div container
     */
    @GetMapping("/stats")
    public String showStats(Model model) {
        model.addAttribute("SHP", statisticsService.getStatisticsCountById(1));
        model.addAttribute("Spot", statisticsService.getStatisticsCountById(2));
        model.addAttribute("Flex", statisticsService.getStatisticsCountById(3));
        model.addAttribute("Base", statisticsService.getStatisticsCountById(4));
        model.addAttribute("Flex2", statisticsService.getStatisticsCountById(5));
        model.addAttribute("Peak", statisticsService.getStatisticsCountById(6));
        return "statistics";
    }
}