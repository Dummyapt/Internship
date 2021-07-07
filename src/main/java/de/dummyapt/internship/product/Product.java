package de.dummyapt.internship.product;

import de.dummyapt.internship.commodity.Commodity;
import lombok.*;

import javax.persistence.*;

/**
 * Spring model of the product table
 */
@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Product {
    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Class attribute annotated as table column
     */
    private String name;
    /**
     * Class attribute annotated as table column
     */
    @Column(columnDefinition = "DEC(5,2)")
    private Double previousPrice;
    /**
     * Class attribute annotated as table column
     */
    @Column(columnDefinition = "DEC(5,2)")
    private Double currentPrice;
    /**
     * Class attribute annotated as table column
     */
    @ManyToOne
    @JoinColumn(name = "commodity_id")
    private Commodity commodity;

    /**
     * Constructor with no id
     * @param name Product name
     * @param currentPrice Current price
     * @param commodity Belonging commodity
     */
    public Product(String name, Double currentPrice, Commodity commodity) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.commodity = commodity;
    }
}