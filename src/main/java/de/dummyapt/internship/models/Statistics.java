package de.dummyapt.internship.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "statistics", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "count")
    private Integer count;
}