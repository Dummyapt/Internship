package de.dummyapt.internship.services;

import de.dummyapt.internship.models.MyUser;
import de.dummyapt.internship.models.MyUserDetails;
import de.dummyapt.internship.repositories.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for MyUserDetails and partially MyUser
 */
@Service
public class MyUserService implements UserDetailsService {
    /**
     * Class attribute providing methods from {@link de.dummyapt.internship.repositories.MyUserRepository}
     */
    private final MyUserRepository myUserRepository;

    /**
     * Internally auto wiring class attributes with parameters
     * @param myUserRepository Needed for autowiring
     */
    @Autowired
    public MyUserService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = myUserRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("User " + username + " wasn't found!"));

        return user.map(MyUserDetails::new).get();
    }
}