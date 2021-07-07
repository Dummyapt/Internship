package de.dummyapt.internship.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * {@link Service} class for {@link ConfirmationToken}
 */
@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    /**
     * Class attribute providing methods from {@link ConfirmationTokenRepository}
     */
    private final ConfirmationTokenRepository confirmationTokenRepository;

    /**
     * Saving token in the database
     * @param token Token
     */
    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    /**
     * Method for getting a token
     * @param token Token
     * @return Token
     */
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    /**
     * Method for setting the confirmation date of a token
     * @param token Token
     */
    public void setConfirmedAt(String token) {
        confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}