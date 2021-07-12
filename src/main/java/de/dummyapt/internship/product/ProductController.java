package de.dummyapt.internship.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * {@link Controller} for {@link ProductService}
 */
@Controller
public class ProductController {
    /**
     * Maps incoming GET requests for http://localhost:8080/
     * @return product.html from the resources/ directory
     */
    @GetMapping("/")
    public String showProductsPage() {
        return "product";
    }
}