package de.dummyapt.internship.models;

import lombok.*;

import javax.persistence.*;

/**
 * Spring model of the commodity table
 */
@Entity
@Table(name = "commodity", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Commodity {
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
    @Column(name = "name")
    private String name;

    /**
     * Constructor with no id
     * @param name Commodity name
     */
    public Commodity(String name) {
        this.name = name;
    }
}