package de.dummyapt.internship.config;

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
public class MyUserService implements MyUserServiceAPI, UserDetailsService {
    /**
     * Class attribute providing methods from {@link MyUserRepository}
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

    @Override
    public String findByUsername(String username) {
        return myUserRepository.findByUsername(username).get().getUsername();
    }
}