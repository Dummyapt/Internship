package de.dummyapt.internship.appuser;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Interface providing {@link CrudRepository} methods
 */
@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    /**
     * Method for finding a user in the database with an email address
     * @param email Email address
     * @return User in database found by the given email address
     */
    Optional<AppUser> findByEmail(String email);

    /**
     * Method for updating the activation status of an user
     * @param email Email address
     */
    @Transactional(readOnly = true)
    @Modifying
    @Query("UPDATE AppUser SET enabled = TRUE WHERE email = ?1")
    void enableAppUser(String email);
}