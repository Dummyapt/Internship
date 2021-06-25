package de.dummyapt.internship.repositories;

import de.dummyapt.internship.models.Commodity;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface providing {@link org.springframework.data.repository.CrudRepository} methods
 */
public interface CommodityRepository extends CrudRepository<Commodity, Integer> {}