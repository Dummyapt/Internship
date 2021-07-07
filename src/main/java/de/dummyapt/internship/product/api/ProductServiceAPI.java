package de.dummyapt.internship.product.api;

import de.dummyapt.internship.product.Product;

import java.util.List;

/**
 * Interface providing methods for retrieving data from the database
 */
public interface ProductServiceAPI {
    /**
     * Method for getting all Product records
     * @return JSON array of the table
     */
    List<Product> getAllProducts();

    /**
     * Method for selecting a specific record
     * @param id Product id
     * @return Product by the given id
     */
    Product getProductById(Integer id);

    /**
     * Method for updating the prices
     */
    void updatePrices();
}