package de.dummyapt.internship.registration.token;

import de.dummyapt.internship.appuser.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Spring model of the confirmation_token table
 */
@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ConfirmationToken {
    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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