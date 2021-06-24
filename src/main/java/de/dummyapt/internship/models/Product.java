package de.dummyapt.internship.models;

import lombok.*;

import javax.persistence.*;

/**
 * Spring model of the product table
 */
@Entity
@Table(name = "product", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Product {
    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * Class attribute annotated as table column
     */
    @Column(name = "name")
    private String name;
    /**
     * Class attribute annotated as table column
     */
    @Column(name = "current_price")
    private Double currentPrice;
    /**
     * Class attribute annotated as table column
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commodity_id")
    private Commodity commodity;
}