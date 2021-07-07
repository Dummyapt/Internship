package de.dummyapt.internship.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * {@link Configuration} for {@link BCryptPasswordEncoder}
 */
@Configuration
public class PasswordEncoder {
    /**
     * {@link Bean} for creating a new {@link BCryptPasswordEncoder} object
     * @return BCryptPasswordEncoder object
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}