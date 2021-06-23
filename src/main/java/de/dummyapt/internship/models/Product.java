package de.dummyapt.internship.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "current_price")
    private Double currentPrice;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commodity_id")
    private Commodity commodity;

    public Product(String name, Double currentPrice, Commodity commodity) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.commodity = commodity;
    }
}