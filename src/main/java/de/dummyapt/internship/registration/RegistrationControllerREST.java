package de.dummyapt.internship.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * {@link RestController} for Registration page
 */
@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationControllerREST {
    /**
     * Class attribute providing methods from {@link RegistrationService}
     */
    private final RegistrationService registrationService;

    /**
     * POST request handler to create/register a user
     * @param request RequestBody
     * @return Registering user with the given credentials
     */
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    /**
     * GET request handler to confirm tokens
     * @param token Token
     * @return Confirming token via POST request
     */
    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}