package de.dummyapt.internship.models;

import lombok.*;

import javax.persistence.*;

/**
 * Spring model of the statistics table
 */
@Entity
@Table(name = "statistics", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Statistics {
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
    @Column(name = "count")
    private Long count;

    /**
     * Constructor with no id
     * @param count Orders count
     */
    public Statistics(Long count) {
        this.count = count;
    }
}