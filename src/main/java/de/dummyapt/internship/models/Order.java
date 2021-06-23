package de.dummyapt.internship.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @NotNull
    @Column(name = "power")
    private Double power;
    @NotNull
    @Column(name = "price")
    private Double price;

    public Order(Product product, Double power, Double price) {
        this.product = product;
        this.power = power;
        this.price = price;
    }
}