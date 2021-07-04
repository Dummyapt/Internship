package de.dummyapt.internship.models;

import de.dummyapt.internship.config.MyUser;
import lombok.*;

import javax.persistence.*;

/**
 * Spring model of the orders table
 */
@Entity
@Table(name = "orders", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Order {
    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * Class attribute annotated as table column
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    /**
     * Class attribute annotated as table column
     */
    @Column(name = "power")
    private Double power;
    /**
     * Class attribute annotated as table column
     */
    @Column(name = "price")
    private Double price;
    /**
     * Class attribute annotated as table column
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private MyUser user;

    /**
     * Constructor with no id
     * @param product Product id
     * @param power Ordered power
     * @param price Total cost
     * @param user Ordering User
     */
    public Order(Product product, Double power, Double price, MyUser user) {
        this.product = product;
        this.power = power;
        this.price = price;
        this.user = user;
    }
}