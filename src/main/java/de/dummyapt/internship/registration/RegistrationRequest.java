package de.dummyapt.internship.registration;

import lombok.*;

/**
 * {@link org.springframework.web.bind.annotation.RequestBody} model
 */
@Getter @Setter @AllArgsConstructor @EqualsAndHashCode @ToString
public class RegistrationRequest {

    /**
     * Username in request
     */
    private String username;

    /**
     * Email in request
     */
    private String email;

    /**
     * Password in request
     */
    private String password;

    /**
     * PasswordConfirmation in request
     */
    private String passwordConfirmation;
}