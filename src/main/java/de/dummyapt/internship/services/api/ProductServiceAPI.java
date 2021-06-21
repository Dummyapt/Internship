package de.dummyapt.internship.services.api;

import de.dummyapt.internship.models.Product;

import java.util.List;

public interface ProductServiceAPI {
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    void updatePrices();
}