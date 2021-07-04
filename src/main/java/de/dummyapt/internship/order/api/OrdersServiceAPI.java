package de.dummyapt.internship.order.api;

import de.dummyapt.internship.order.Orders;

import java.util.List;
import java.util.Optional;

/**
 * Interface providing methods for retrieving data from the database
 */
public interface OrdersServiceAPI {
    /**
     * Method for getting all Orders records
     * @return JSON array of the table
     */
    List<Orders> getAllOrders();

    /**
     * Method for selecting a specific record
     * @param id Order id
     * @return Order by the given id
     */
    Optional<Orders> getOrderById(Integer id);

    /**
     * Method for retrieving the amount of orders by the given product id
     * @param productId Product id
     * @return Count of orders
     */
    Integer getOrderCount(Integer productId);

    /**
     * Method for creating a new order record in the database
     * @param productId Product id
     * @param power Power value
     * @param price Total cost
     */
    void saveOrder(Integer productId, Double power, Double price, String user);
}