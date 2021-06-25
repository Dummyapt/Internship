package de.dummyapt.internship.repositories;

import de.dummyapt.internship.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface providing {@link org.springframework.data.repository.CrudRepository} methods
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
    /**
     * Scheduled query for updating the prices randomly with a value between 0 and 1
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE product SET current_price = RAND() WHERE id > 0", nativeQuery = true)
    void updatePrices();

    /**
     * Method for finding a product by the passed id
     * @param id Product id that should be chosen
     * @return Object of Product
     */
    Product findProductById(Integer id);
}