package de.dummyapt.internship.config;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Spring model of the users table
 */
@Entity
@Table(name = "users", schema = "internship")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MyUser {
    /**
     * Class attribute annotated as table column
     */
    @Id
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
    @Column(name = "authorities")
    private String authorities;
}