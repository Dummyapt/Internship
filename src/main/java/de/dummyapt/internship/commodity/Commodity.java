package de.dummyapt.internship.commodity;

import lombok.*;

import javax.persistence.*;

/**
 * Spring model of the commodity table
 */
@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Commodity {
    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Class attribute annotated as table column
     */
    private String name;

    /**
     * Constructor with no id
     * @param name Commodity name
     */
    public Commodity(String name) {
        this.name = name;
    }
}