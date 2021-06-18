package de.dummyapt.internship.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "power")
    private BigDecimal power;
    @Column(name = "price")
    private BigDecimal price;
}