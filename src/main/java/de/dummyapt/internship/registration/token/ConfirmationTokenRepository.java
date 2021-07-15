package de.dummyapt.internship.registration.token;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Interface providing {@link CrudRepository} methods
 */
@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Integer> {

    /**
     * Method for searching a token in the database
     * @param token Token
     * @return Token found by given token
     */
    Optional<ConfirmationToken> findByToken(String token);

    /**
     * Method for updating the date after a token has been verified
     * @param token Token
     * @param confirmedAt Date when the token was
     */
    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationToken SET confirmedAt = ?2 WHERE token = ?1")
    void updateConfirmedAt(String token, LocalDateTime confirmedAt);
}