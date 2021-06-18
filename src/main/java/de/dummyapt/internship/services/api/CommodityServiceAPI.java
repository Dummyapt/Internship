package de.dummyapt.internship.services.api;

import de.dummyapt.internship.models.Commodity;

import java.util.List;
import java.util.Optional;

public interface CommodityServiceAPI {
    List<Commodity> getAllCommodities();
    Optional<Commodity> getCommodityById(Integer id);
}