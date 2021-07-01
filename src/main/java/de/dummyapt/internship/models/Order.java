package de.dummyapt.internship.models;

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
    @JoinColumn(name = "user_username")
    private MyUser user;
}