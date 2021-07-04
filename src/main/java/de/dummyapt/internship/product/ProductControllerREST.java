package de.dummyapt.internship.product;

import de.dummyapt.internship.order.api.OrdersServiceAPI;
import de.dummyapt.internship.product.api.ProductServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link org.springframework.web.bind.annotation.RestController} for Product service
 */
@RestController
public class ProductControllerREST {
    /**
     * Class attribute providing methods from {@link ProductServiceAPI}
     */
    private final ProductServiceAPI productService;
    /**
     * Class attribute providing methods from {@link OrdersServiceAPI}
     */
    private final OrdersServiceAPI orderService;

    /**
     * Internally auto wiring class attributes with parameters
     * @param productService Needed for autowiring
     * @param orderService Needed for autowiring
     */
    @Autowired
    public ProductControllerREST(ProductServiceAPI productService,
                                 OrdersServiceAPI orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    // TODO: 01.07.2021 Add user as request parameter provided by myUserService
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
                            <th>ID</th>
                            <th>Name</th>
                            <th>Aktueller Preis</th>
                            <th>Commodity</th>
                            <th>Leistung</th>
                            <th>Kaufen</th>
                        </tr>
                    </thead>
                    <tbody>""");
        var openAndClose = "</td><td>";
        var i = 0;
        for (Product product : products) {
            i++;
            stringBuilder.append("<tr><td>")
                    .append(product.getId()).append(openAndClose)
                    .append(product.getName()).append(openAndClose)
                    .append(product.getCurrentPrice()).append("€").append(openAndClose)
                    .append(product.getCommodity().getName()).append(openAndClose)
                    .append("<input type=number min=0 class=\"valueInput").append(i).append("\">").append(openAndClose)
                    .append("<a ")
                    .append("id=").append("\"").append("confirmOrder").append(i).append("\"")
                    .append("role=").append("\"").append("button").append("\"")
                    .append("class=").append("\"").append("btn btn-primary").append("\"")
                    .append("data-bs-toggle=").append("\"").append("modal").append("\"")
                    .append("data-bs-target=").append("\"").append("#orderModal").append("\"")
                    .append("data-productid=").append("\"").append(product.getId()).append("\"")
                    .append("data-productname=").append("\"").append(product.getName()).append("\"")
                    .append("data-productcurrentprice=").append("\"").append(product.getCurrentPrice()).append("\"")
                    .append("data-productcommodity=").append("\"").append(product.getCommodity().getName()).append("\"")
                    .append(">").append("Kaufen</a>")
                    .append("</td></tr>");
        }
        stringBuilder.append("""
                    </tbody>
                </table>""");
        return stringBuilder.toString();
    }

    /**
     * Maps incoming POST requests for http://localhost:8080/confirmOrder
     * @param id Getting the value of posted data
     * @param power Getting the value of posted data
     * @param cost Getting the value of posted data
     * @param user Getting the value of posted data
     * @return New order in the corresponding database
     */
    @PostMapping("/confirmOrder")
    public String confirmOrder(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "power") Double power,
            @RequestParam(value = "cost") Double cost,
            @RequestParam(value = "user") String user) {
        orderService.saveOrder(id, power, cost, user);
        return "";
    }

    /**
     * Maps incoming GET requests for http://localhost:8080/orderSuccess
     * @return Bootstrap alert
     */
    @GetMapping("/orderSuccess")
    public String showOrderSuccess() {
        return """
                <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
                    <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
                        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                    </symbol>
                </svg>
    
                <div class="alert alert-success d-flex align-items-center" role="alert">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
                    <div>
                        Bestellung aufgegeben!
                    </div>
                </div>""";
    }

    /**
     * Maps incoming GET requests for http://localhost:8080/orderError
     * @return Bootstrap alert
     */
    @GetMapping("/orderError")
    public String showOrderError() {
        return """
                <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
                    <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
                        <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                    </symbol>
                </svg>

                <div class="alert alert-danger d-flex align-items-center" role="alert">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                    <div>
                        Ein Fehler ist aufgetreten!
                    </div>
                </div>""";
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