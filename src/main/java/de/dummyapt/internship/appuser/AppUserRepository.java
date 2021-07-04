package de.dummyapt.internship.appuser;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
    @Transactional(readOnly = true)
    @Modifying
    @Query("UPDATE AppUser SET enabled = TRUE WHERE email = ?1")
    int enableAppUser(String email);
}