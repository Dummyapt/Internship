package de.dummyapt.internship.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * {@link org.springframework.web.bind.annotation.RequestBody} model
 */
@Getter @AllArgsConstructor @EqualsAndHashCode @ToString
public class RegistrationRequest {
    /**
     * Username in request
     */
    private final String username;
    /**
     * Email in request
     */
    private final String email;
    /**
     * Password in request
     */
    private final String password;
}