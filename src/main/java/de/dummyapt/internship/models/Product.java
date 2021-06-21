package de.dummyapt.internship.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "current_price")
    private Double currentPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commodity_id")
    private Commodity commodity;

    public Product(String name, Double currentPrice, Commodity commodity) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.commodity = commodity;
    }
}