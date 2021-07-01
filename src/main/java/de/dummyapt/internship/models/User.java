package de.dummyapt.internship.models;

import lombok.*;

import javax.persistence.*;

/**
 * Spring model of the users table
 */
@Entity
@Table(name = "users", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class User {
    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    /**
     * Class attribute annotated as table column
     */
    @Column(name = "username")
    private String username;
    /**
     * Class attribute annotated as table column
     */
    @Column(name = "password")
    private String password;
    /**
     * Class attribute annotated as table column
     */
    @Column(name = "active")
    private boolean active;
    /**
     * Class attribute annotated as table column
     */
    @Column(name = "roles")
    private String roles;
}