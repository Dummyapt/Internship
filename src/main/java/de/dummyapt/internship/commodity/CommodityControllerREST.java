package de.dummyapt.internship.commodity;

import de.dummyapt.internship.commodity.api.CommodityServiceAPI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link RestController} for {@link CommodityService}
 */
@RestController
@AllArgsConstructor
public class CommodityControllerREST {
    /**
     * Class attribute providing methods from {@link CommodityServiceAPI}
     */
    private final CommodityServiceAPI commodityService;

    /**
     * Method for retrieving data from the database
     * and create a JSON array
     * @return api/v1/commodities with a JSON array
     */
    @GetMapping("/api/v1/commodities")
    public List<Commodity> showAPI() {
        List<Commodity> commodityList;
        commodityList = commodityService.getAllCommodities();
        return commodityList;
    }
}