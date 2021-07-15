package de.dummyapt.internship.order;

import de.dummyapt.internship.order.api.OrdersServiceAPI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * {@link Service} class for {@link Orders}
 */
@Service
@AllArgsConstructor
public class OrdersService implements OrdersServiceAPI {

    /**
     * Class attribute providing methods from {@link OrdersRepository}
     */
    private final OrdersRepository ordersRepository;

    @Override
    public List<Orders> getAllOrders() {
        return (List<Orders>) ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> getOrderById(Integer id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Integer getOrderCount(Integer productId) {
        return ordersRepository.getOrderCount(productId);
    }

    @Override
    public void saveOrder(Integer productId, Double power, Double price, String user) {
        ordersRepository.saveOrder(productId, power, price, user);
    }
}