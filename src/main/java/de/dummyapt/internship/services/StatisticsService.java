package de.dummyapt.internship.services;

import de.dummyapt.internship.models.Statistics;
import de.dummyapt.internship.repositories.StatisticsRepository;
import de.dummyapt.internship.services.api.StatisticsServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticsService implements StatisticsServiceAPI {
    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public List<Statistics> getAllStatistics() {
        return (List<Statistics>) statisticsRepository.findAll();
    }

    @Override
    public Optional<Statistics> getStatisticById(Integer id) {
        return statisticsRepository.findById(id);
    }

    @Override
    public Integer getStatisticsCountBy(Integer id) {
        return statisticsRepository.getStatisticsCountBy(id);
    }
}