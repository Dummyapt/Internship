package de.dummyapt.internship.services.api;

import de.dummyapt.internship.models.Statistics;

import java.util.List;
import java.util.Optional;

/**
 * Interface providing methods for retrieving data from the database
 */
public interface StatisticsServiceAPI {
    /**
     * Method for getting all Statistics records
     * @return JSON array of the table
     */
    List<Statistics> getAllStatistics();

    /**
     * Method for selecting a specific record
     * @param id Statistics id
     * @return Statistics by the given id
     */
    Optional<Statistics> getStatisticById(Integer id);

    /**
     * Method for retrieving the amount of orders by the given product id
     * @param id Statistics id
     * @return Count of orders
     */
    Integer getStatisticsCountById(Integer id);
}