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
    @Autowired
    private CommodityRepository commodityRepository;

    @Override
    public List<Commodity> getAllCommodities() {
        return (List<Commodity>) commodityRepository.findAll();
    }

    @Override
    public Optional<Commodity> getCommodityById(Integer id) {
        return commodityRepository.findById(id);
    }
}