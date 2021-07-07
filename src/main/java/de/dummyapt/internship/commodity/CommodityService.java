package de.dummyapt.internship.commodity;

import de.dummyapt.internship.commodity.api.CommodityServiceAPI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * {@link Service} class for {@link Commodity}
 */
@Service
@AllArgsConstructor
public class CommodityService implements CommodityServiceAPI {
    /**
     * Class attribute providing methods from {@link CommodityServiceAPI}
     */
    private final CommodityRepository commodityRepository;

    @Override
    public List<Commodity> getAllCommodities() {
        return (List<Commodity>) commodityRepository.findAll();
    }

    @Override
    public Optional<Commodity> getCommodityById(Integer id) {
        return commodityRepository.findById(id);
    }
}