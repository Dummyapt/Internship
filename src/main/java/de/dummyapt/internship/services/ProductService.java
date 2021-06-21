package de.dummyapt.internship.services;

import de.dummyapt.internship.models.Product;
import de.dummyapt.internship.repositories.ProductRepository;
import de.dummyapt.internship.services.api.ProductServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
public class ProductService implements ProductServiceAPI {
    private final ProductRepository productRepository;

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