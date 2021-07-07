package de.dummyapt.internship.statistics;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface providing {@link CrudRepository} methods
 */
@Repository
public interface StatisticsRepository extends CrudRepository<Statistics, Integer> {
    /**
     * Method for finding a statistics value by the passed id
     * @param id Product id of the statistics that should be chosen
     * @return Count of made orders
     */
    @Query(value = "SELECT count FROM statistics WHERE id = :id", nativeQuery = true)
    Integer getStatisticsCountBy(Integer id);
}