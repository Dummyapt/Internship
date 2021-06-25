package de.dummyapt.internship.controllers;

import de.dummyapt.internship.models.Statistics;
import de.dummyapt.internship.services.api.StatisticsServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link org.springframework.web.bind.annotation.RestController} for Statistics service
 */
@RestController
public class StatisticsControllerREST {
    /**
     * Class attribute providing methods from {@link de.dummyapt.internship.services.api.StatisticsServiceAPI}
     */
    private final StatisticsServiceAPI statisticsService;

    /**
     * Internally auto wiring class attributes with parameters
     */
    @Autowired
    public StatisticsControllerREST(StatisticsServiceAPI statisticsService) {
        this.statisticsService = statisticsService;
    }

    /**
     * Method for retrieving data from the database
     * and create a JSON array
     * @return api/v1/statistics with a JSON array
     */
    @GetMapping("/api/v1/statistics")
    public List<Statistics> showAPI() {
        List<Statistics> statisticsList;
        statisticsList = statisticsService.getAllStatistics();
        return statisticsList;
    }
}