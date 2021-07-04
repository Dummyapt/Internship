package de.dummyapt.internship.commodity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface providing {@link org.springframework.data.repository.CrudRepository} methods
 */
@Repository
public interface CommodityRepository extends CrudRepository<Commodity, Integer> {}