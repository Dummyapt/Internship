package de.dummyapt.internship.services;

import de.dummyapt.internship.models.Product;
import de.dummyapt.internship.repositories.ProductRepository;
import de.dummyapt.internship.services.api.ProductServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Product
 */
@Service
@EnableScheduling
public class ProductService implements ProductServiceAPI {
    /**
     * Class attribute providing methods from {@link de.dummyapt.internship.services.api.CommodityServiceAPI}
     */
    private final ProductRepository productRepository;

    /**
     * Internally auto wiring class attributes with parameters
     * @param productRepository Needed for autowiring
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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
        productRepository.updatePrices();
    }
}