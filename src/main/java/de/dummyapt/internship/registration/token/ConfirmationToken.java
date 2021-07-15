package de.dummyapt.internship.registration.token;

import de.dummyapt.internship.appuser.AppUser;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Spring model of the confirmation_token table
 */
@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class ConfirmationToken {

    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Class attribute annotated as table column
     */
    @Column(nullable = false)
    private String token;

    /**
     * Class attribute annotated as table column
     */
    @Column(nullable = false)
    private LocalDateTime createdAt;

    /**
     * Class attribute annotated as table column
     */
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    /**
     * Class attribute annotated as table column
     */
    private LocalDateTime confirmedAt;

    /**
     * Class attribute annotated as table column
     */
    @ManyToOne
    @JoinColumn(name = "app_user_id", nullable = false)
    private AppUser appUser;

    /**
     * Constructor with no id
     * @param token Token
     * @param createdAt Date when the user was created
     * @param expiresAt Date when the user will expire
     * @param appUser User object
     */
    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             AppUser appUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.appUser = appUser;
    }
}