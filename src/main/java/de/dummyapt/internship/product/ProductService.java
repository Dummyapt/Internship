package de.dummyapt.internship.product;

import de.dummyapt.internship.product.api.ProductServiceAPI;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@link Service} class for {@link Product}
 */
@Service
@EnableScheduling
@AllArgsConstructor
public class ProductService implements ProductServiceAPI {
    /**
     * Class attribute providing methods from {@link ProductServiceAPI}
     */
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    @Scheduled(fixedDelay = 30_000)
    public void updatePrices() {
        productRepository.copyCurrentPrices();
        productRepository.updatePrices();
    }
}