package de.dummyapt.internship.repositories;

import de.dummyapt.internship.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query(value = "SELECT COUNT(product_id) FROM orders WHERE product_id = :productId", nativeQuery = true)
    Integer getOrderCount(@Param("productId") Integer productId);
    @Query(value = "INSERT INTO orders (product_id, power, price) VALUES (:productId, :power, :price)", nativeQuery = true)
    void saveOrder(Integer productId, Double power, Double price);
}