package de.dummyapt.internship.statistics;

import de.dummyapt.internship.statistics.api.StatisticsServiceAPI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link RestController} for Statistics service
 */
@RestController
@AllArgsConstructor
public class StatisticsRestController {

    /**
     * Class attribute providing methods from {@link StatisticsServiceAPI}
     */
    private final StatisticsServiceAPI statisticsService;

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