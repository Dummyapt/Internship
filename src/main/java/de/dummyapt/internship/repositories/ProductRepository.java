package de.dummyapt.internship.repositories;

import de.dummyapt.internship.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE product SET current_price = RAND()", nativeQuery = true)
    void updatePrices();
    Product findProductById(Integer id);
}