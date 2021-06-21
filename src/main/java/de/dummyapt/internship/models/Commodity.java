package de.dummyapt.internship.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "commodity", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    public Commodity(String name) {
        this.name = name;
    }
}