package de.dummyapt.internship.product;

import de.dummyapt.internship.product.api.ProductServiceAPI;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link RestController} for {@link ProductService}
 */
@RestController
@AllArgsConstructor
public class ProductControllerREST {
    /**
     * Class attribute providing methods from {@link ProductServiceAPI}
     */
    private final ProductServiceAPI productService;

    /**
     * Maps incoming GET requests for http://localhost:8080/productList
     * @return Dynamically generated table in form of html code
     * with data retrieved from the database
     */
    @GetMapping("/productList")
    public String showProducts() {
        List<Product> products;
        products = productService.getAllProducts();
        var stringBuilder = new StringBuilder();
        stringBuilder.append("""
                <table class="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Previous price</th>
                            <th>Current price</th>
                            <th>Price development</th>
                            <th>Commodity</th>
                            <th>Power</th>
                            <th>Buy</th>
                        </tr>
                    </thead>
                    <tbody>""");
        var openAndClose = "</td><td>";
        var i = 0;
        for (Product product : products) {
            var auth = SecurityContextHolder.getContext().getAuthentication();
            i++;
            stringBuilder.append("<tr><td>")
                    .append(product.getName()).append(openAndClose)
                    .append(product.getPreviousPrice()).append("€").append(openAndClose)
                    .append(product.getCurrentPrice()).append("€").append(openAndClose);
            if (product.getPreviousPrice() > product.getCurrentPrice()) {
                stringBuilder.append("<span style=\"color:green; font-size:30px;\">").append("↑").append("</span>").append(openAndClose);
            } else if (product.getPreviousPrice() < product.getCurrentPrice()) {
                stringBuilder.append("<span style=\"color:red; font-size:30px;\">").append("↓").append("</span>").append(openAndClose);
            } else {
                stringBuilder.append("<span style=\"font-size:30px;\">").append("-").append("</span>").append(openAndClose);
            }
            stringBuilder
                    .append(product.getCommodity().getName()).append(openAndClose)
                    .append("<input type=number min=0 class=\"valueInput").append(i).append("\">").append(openAndClose)
                    .append("<a ")
                    .append("id=").append("\"").append("confirmOrder").append(i).append("\"")
                    .append("role=").append("\"").append("button").append("\"")
                    .append("class=").append("\"").append("btn btn-primary").append("\"")
                    .append("data-bs-toggle=").append("\"").append("modal").append("\"")
                    .append("data-bs-target=").append("\"").append("#orderModal").append("\"")
                    .append("data-product-id=").append("\"").append(product.getId()).append("\"")
                    .append("data-product-name=").append("\"").append(product.getName()).append("\"")
                    .append("data-product-previous-price=").append("\"").append(product.getPreviousPrice()).append("\"")
                    .append("data-product-current-price=").append("\"").append(product.getCurrentPrice()).append("\"")
                    .append("data-product-commodity=").append("\"").append(product.getCommodity().getName()).append("\"")
                    .append("data-customer=").append("\"").append(auth.getName()).append("\"")
                    .append(">").append("Buy</a>")
                    .append("</td></tr>");
        }
        stringBuilder.append("""
                    </tbody>
                </table>""");
        return stringBuilder.toString();
    }

    /**
     * Method for retrieving data from the database
     * and create a JSON array
     * @return api/v1/products with a JSON array
     */
    @GetMapping("/api/v1/products")
    public List<Product> showAPI() {
        List<Product> productList;
        productList = productService.getAllProducts();
        return productList;
    }
}