package de.dummyapt.internship.statistics;

import de.dummyapt.internship.commodity.api.CommodityServiceAPI;
import de.dummyapt.internship.statistics.api.StatisticsServiceAPI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for Statistics
 */
@Service
@AllArgsConstructor
public class StatisticsService implements StatisticsServiceAPI {
    /**
     * Class attribute providing methods from {@link CommodityServiceAPI}
     */
    private final StatisticsRepository statisticsRepository;

    @Override
    public List<Statistics> getAllStatistics() {
        return (List<Statistics>) statisticsRepository.findAll();
    }

    @Override
    public Optional<Statistics> getStatisticById(Integer id) {
        return statisticsRepository.findById(id);
    }

    @Override
    public Integer getStatisticsCountById(Integer id) {
        return statisticsRepository.getStatisticsCountBy(id);
    }
}