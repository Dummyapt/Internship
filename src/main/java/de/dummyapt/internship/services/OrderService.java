package de.dummyapt.internship.services;

import de.dummyapt.internship.models.Order;
import de.dummyapt.internship.repositories.OrderRepository;
import de.dummyapt.internship.services.api.OrderServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for Order
 */
@Service
public class OrderService implements OrderServiceAPI {
    /**
     * Class attribute providing methods from {@link de.dummyapt.internship.services.api.CommodityServiceAPI}
     */
    private final OrderRepository orderRepository;

    /**
     * Internally auto wiring class attributes with parameters
     * @param orderRepository Needed for autowiring
     */
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Integer getOrderCount(Integer productId) {
        return orderRepository.getOrderCount(productId);
    }

    @Override
    public void saveOrder(Integer productId, Double power, Double price, String user) {
        orderRepository.saveOrder(productId, power, price, user);
    }
}