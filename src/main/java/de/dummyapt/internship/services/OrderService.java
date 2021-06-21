package de.dummyapt.internship.services;

import de.dummyapt.internship.models.Order;
import de.dummyapt.internship.repositories.OrderRepository;
import de.dummyapt.internship.services.api.OrderServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderServiceAPI {
    private final OrderRepository orderRepository;

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
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}