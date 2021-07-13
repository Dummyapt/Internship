package de.dummyapt.internship.product;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface providing {@link CrudRepository} methods
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    /**
     * Scheduled query for updating the prices randomly with a value between 0 and 1
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE product SET current_price = RAND()", nativeQuery = true)
    void updatePrices();

    /**
     * Query for showing the price development
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE product SET previous_price = current_price", nativeQuery = true)
    void copyCurrentPrices();

    /**
     * Method for finding a product by the passed id
     * @param id Product id that should be chosen
     * @return Object of Product
     */
    Product findProductById(Integer id);
}