package de.dummyapt.internship.services.api;

import de.dummyapt.internship.models.Commodity;

import java.util.List;
import java.util.Optional;

/**
 * Interface providing methods for retrieving data from the database
 */
public interface CommodityServiceAPI {
    /**
     * Method for getting all Commodity records
     * @return JSON array of the table
     */
    List<Commodity> getAllCommodities();

    /**
     * Method for selecting a specific record
     * @param id Commodity id
     * @return Commodity by the given id
     */
    Optional<Commodity> getCommodityById(Integer id);
}