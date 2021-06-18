package de.dummyapt.internship.repositories;

import de.dummyapt.internship.models.Commodity;
import org.springframework.data.repository.CrudRepository;

public interface CommodityRepository extends CrudRepository<Commodity, Integer> {}