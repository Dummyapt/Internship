package de.dummyapt.internship.order;

import de.dummyapt.internship.product.Product;
import lombok.*;

import javax.persistence.*;

/**
 * Spring model of the orders table
 */
@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Orders {

    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Class attribute annotated as table column
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Class attribute annotated as table column
     */
    @Column(columnDefinition = "DEC(7,2)")
    private Double power;

    /**
     * Class attribute annotated as table column
     */
    @Column(columnDefinition = "DEC(7,2)")
    private Double price;

    /**
     * Class attribute annotated as table column
     */
    private String customer;

    /**
     * Constructor with no id
     * @param product Product id
     * @param power Ordered power
     * @param price Total cost
     * @param customer Ordering customer
     */
    public Orders(Product product, Double power, Double price, String customer) {
        this.product = product;
        this.power = power;
        this.price = price;
        this.customer = customer;
    }
}