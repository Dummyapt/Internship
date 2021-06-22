package de.dummyapt.internship.controllers;

import de.dummyapt.internship.models.Product;
import de.dummyapt.internship.services.api.OrderServiceAPI;
import de.dummyapt.internship.services.api.ProductServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerREST {
    private final ProductServiceAPI productService;
    private final OrderServiceAPI orderService;

    @Autowired
    public ProductControllerREST(ProductServiceAPI productService, OrderServiceAPI orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

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

    @PostMapping("/productList")
    public void confirmOrder() {
        System.out.println("Bing");
        orderService.saveOrder(1, 1.0, 1.0);
    }
}