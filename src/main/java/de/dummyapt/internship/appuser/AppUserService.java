package de.dummyapt.internship.appuser;

import de.dummyapt.internship.registration.token.ConfirmationToken;
import de.dummyapt.internship.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * {@link Service} class for {@link AppUser}
 */
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    /**
     * Class attribute providing methods from {@link AppUserRepository}
     */
    private final AppUserRepository appUserRepository;
    /**
     * Class attribute providing methods from {@link BCryptPasswordEncoder}
     */
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     * Class attribute providing methods from {@link ConfirmationTokenService}
     */
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with the given email was not found!"));
    }

    /**
     * Method for signing up a new user
     * @param appUser User object
     * @return Token
     */
    public String signUpUser(AppUser appUser) {
        var userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if (userExists) {
            return "Email taken!";
        }

        var encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);

        var token = UUID.randomUUID().toString();
        var confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    /**
     * Method enabling a user
     * @param email User email address
     */
    public void enableAppUser(String email) {
        appUserRepository.enableAppUser(email);
    }
}