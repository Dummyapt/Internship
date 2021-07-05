package de.dummyapt.internship.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Interface providing {@link org.springframework.data.repository.CrudRepository} methods
 */
@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {
    /**
     * Database query selecting the records with the given product id
     * @param productId Product id, that should be chosen
     * @return How many times a product corresponding to
     * the given product id has been ordered
     */
    @Query(value = "SELECT COUNT(product_id) FROM orders WHERE product_id = :productId", nativeQuery = true)
    Integer getOrderCount(@Param("productId") Integer productId);

    /**
     * Query for creating a new record in the orders table
     * @param productId Product id
     * @param power Power value
     * @param price Total cost
     * @param user User making order
     */
    @Query(value = "INSERT INTO orders (product_id, power, price, customer) VALUES (:productId, :power, :price, :user)", nativeQuery = true)
    void saveOrder(Integer productId, Double power, Double price, String user);
}