package de.dummyapt.internship.services.api;

import de.dummyapt.internship.models.Statistics;

import java.util.List;
import java.util.Optional;

public interface StatisticsServiceAPI {
    List<Statistics> getAllStatistics();
    Optional<Statistics> getStatisticById(Integer id);
    Integer getStatisticsCountBy(Integer id);
}