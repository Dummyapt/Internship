package de.dummyapt.internship.services;

import de.dummyapt.internship.models.Commodity;
import de.dummyapt.internship.repositories.CommodityRepository;
import de.dummyapt.internship.services.api.CommodityServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommodityService implements CommodityServiceAPI {
    /**
     * Class attribute providing methods from {@link de.dummyapt.internship.services.api.CommodityServiceAPI}
     */
    private final CommodityRepository commodityRepository;

    /**
     * Internally auto wiring class attributes with parameters
     */
    @Autowired
    public CommodityService(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    @Override
    public List<Commodity> getAllCommodities() {
        return (List<Commodity>) commodityRepository.findAll();
    }

    @Override
    public Optional<Commodity> getCommodityById(Integer id) {
        return commodityRepository.findById(id);
    }
}