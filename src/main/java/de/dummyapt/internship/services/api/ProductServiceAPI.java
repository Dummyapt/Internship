package de.dummyapt.internship.services.api;

import de.dummyapt.internship.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceAPI {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Integer id);
    void updatePrices();
}