package de.dummyapt.internship.services.api;

import de.dummyapt.internship.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderServiceAPI {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Integer id);
    Integer getOrderCount(Integer productId);
}