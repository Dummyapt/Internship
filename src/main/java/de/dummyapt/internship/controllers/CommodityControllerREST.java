package de.dummyapt.internship.controllers;

import de.dummyapt.internship.models.Commodity;
import de.dummyapt.internship.services.api.CommodityServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link org.springframework.web.bind.annotation.RestController} for Commodity service
 */
@RestController
public class CommodityControllerREST {
    /**
     * Class attribute providing methods from {@link de.dummyapt.internship.services.api.CommodityServiceAPI}
     */
    private final CommodityServiceAPI commodityService;

    /**
     * Internally auto wiring class attributes with parameters
     * @param commodityService Needed for autowiring
     */
    @Autowired
    public CommodityControllerREST(CommodityServiceAPI commodityService) {
        this.commodityService = commodityService;
    }

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