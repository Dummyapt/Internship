package de.dummyapt.internship.product;

import de.dummyapt.internship.commodity.api.CommodityServiceAPI;
import de.dummyapt.internship.product.api.ProductServiceAPI;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Product
 */
@Service
@EnableScheduling
@AllArgsConstructor
public class ProductService implements ProductServiceAPI {
    /**
     * Class attribute providing methods from {@link CommodityServiceAPI}
     */
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    @Scheduled(fixedDelay = 30_000)
    public void updatePrices() {
        productRepository.updatePrices();
    }
}