package de.dummyapt.internship.repositories;

import de.dummyapt.internship.models.Statistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StatisticsRepository extends CrudRepository<Statistics, Integer> {
    @Query(value = "SELECT count FROM statistics WHERE id = :id", nativeQuery = true)
    Integer getStatisticsCountBy(Integer id);
}