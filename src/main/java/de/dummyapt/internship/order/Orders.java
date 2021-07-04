package de.dummyapt.internship.order;

import de.dummyapt.internship.appuser.AppUser;
import de.dummyapt.internship.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Spring model of the orders table
 */
@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Orders {
    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(columnDefinition = "DEC(5,2)")
    private Double power;
    /**
     * Class attribute annotated as table column
     */
    @Column(columnDefinition = "DEC(5,2)")
    private Double price;
    /**
     * Class attribute annotated as table column
     */
    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    /**
     * Constructor with no id
     * @param product Product id
     * @param power Ordered power
     * @param price Total cost
     * @param appUser Ordering User
     */
    public Orders(Product product, Double power, Double price, AppUser appUser) {
        this.product = product;
        this.power = power;
        this.price = price;
        this.appUser = appUser;
    }
}