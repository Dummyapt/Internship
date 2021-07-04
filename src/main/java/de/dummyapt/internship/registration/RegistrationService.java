package de.dummyapt.internship.registration;

import de.dummyapt.internship.appuser.AppUser;
import de.dummyapt.internship.appuser.AppUserRole;
import de.dummyapt.internship.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid!");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}