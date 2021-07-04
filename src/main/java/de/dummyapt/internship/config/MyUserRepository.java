package de.dummyapt.internship.config;

import de.dummyapt.internship.config.MyUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Interface providing {@link org.springframework.data.repository.CrudRepository} methods
 */
public interface MyUserRepository extends CrudRepository<MyUser, Integer> {
    /**
     * Method for selecting a specific record
     * @param username Name of the user
     * @return User by the given username
     */
    Optional<MyUser> findByUsername(String username);
}