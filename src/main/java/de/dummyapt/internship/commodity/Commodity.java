package de.dummyapt.internship.commodity;

import lombok.*;

import javax.persistence.*;

/**
 * Spring model of the {@link Commodity} table
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
    private Integer id;

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