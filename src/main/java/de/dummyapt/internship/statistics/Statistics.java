package de.dummyapt.internship.statistics;

import lombok.*;

import javax.persistence.*;

/**
 * Spring model of the statistics table
 */
@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Statistics {

    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Class attribute annotated as table column
     */
    private Integer count;

    /**
     * Constructor with no id
     * @param count Orders count
     */
    public Statistics(Integer count) {
        this.count = count;
    }
}